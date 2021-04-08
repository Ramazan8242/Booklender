package kz.attractor.java.lesson45;

import com.sun.net.httpserver.HttpExchange;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import kz.attractor.java.server.BasicServer;
import kz.attractor.java.server.ContentType;
import kz.attractor.java.server.ResponseCodes;
import kz.attractor.java.server.Utils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.joining;

public class Lesson45Server extends BasicServer {
    public static final String  EMAIL = "email";
    private final static Configuration freemarker = initFreeMarker();
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    private List<User> users = new ArrayList<>();

    public Lesson45Server(String host, int port) throws IOException {
        super(host, port);
        registerGet("/sample", this::freemarkerSampleHandler);

        registerGet("/books", this::freemarkerBookHandler);
        registerGet("/user", this::freemarkerUserHandler);
        registerGet("/home", this::freemarkerHomePageHandler);

        registerGet("/login", this::loginGet);
        registerPost("/login", this::loginPost);

        registerGet("/register", this::registerGetRequest);
        registerPost("/register", this::registerPostRequest);

        registerGet("/profile", this::profileGet);
    }

    private void profileGet(HttpExchange httpExchange) {
        Path path = makeFilePath("profile.html");
        sendFile(httpExchange,path,ContentType.TEXT_HTML);
    }

    private static Configuration initFreeMarker() {
        try {
            Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
            // путь к каталогу в котором у нас хранятся шаблоны
            // это может быть совершенно другой путь, чем тот, откуда сервер берёт файлы
            // которые отправляет пользователю
            cfg.setDirectoryForTemplateLoading(new File("data"));

            // прочие стандартные настройки о них читать тут
            // https://freemarker.apache.org/docs/pgui_quickstart_createconfiguration.html
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            return cfg;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void freemarkerSampleHandler(HttpExchange exchange) {
        renderTemplate(exchange,"sample.html", getSampleDataModel());
    }
    private void freemarkerBookHandler(HttpExchange exchange) {
        renderTemplate(exchange,"books.html", getBookDataModel());
    }
    private void freemarkerUserHandler(HttpExchange httpExchange) {
        renderTemplate(httpExchange,"user.ftl", getUserDataModel());
    }
    private void freemarkerHomePageHandler(HttpExchange httpExchange) {
        renderTemplate(httpExchange,"home.ftl", getHomePageDataModel());
    }
    private void registerGetRequest(HttpExchange httpExchange) {
        Path path = makeFilePath("register.html");
        sendFile(httpExchange,path,ContentType.TEXT_HTML);
    }
    private void registerPostRequest(HttpExchange exchange) {
        String cType = getContentType(exchange);
        String raw = getBody(exchange);
        Map<String, String> parsed =
                Utils.parseUrlEncoded(raw, "&");
        if (isValidUser(parsed)) {
            redirect303(exchange,"/profile");
            return;
        }
        redirect303(exchange,"/login");
    }

    private User registrationUser(Map<String, String> parsed) {
//        User newUser = new User();
//        newUser.setEmail(parsed.get(EMAIL));
//        newUser.setLogin(parsed.get(LOGIN));
//        newUser.setPassword(parsed.get(PASSWORD));
//        users.add(newUser);
//        return newUser;
            User newUser = User.makeUser(parsed.get(EMAIL), parsed.get(LOGIN), parsed.get(PASSWORD));
            users.add(newUser);
        return newUser;
    }

    private boolean isExistUser(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    private void loginGet(HttpExchange exchange) {
        Path path = makeFilePath("login.html");
        sendFile(exchange,path,ContentType.TEXT_HTML);
    }
    private void  loginPost(HttpExchange exchange) {
        String cType = getContentType(exchange);
        String raw = getBody(exchange);

        Map<String, String> parsed =
                Utils.parseUrlEncoded(raw, "&");
        if(isExistUser(parsed.get(EMAIL))){
            renderTemplate(exchange, "error.html", parsed);
            return;
        }
        User user = registrationUser(parsed);
        renderTemplate(exchange, "profile.html", user);
    }

    private boolean isValidUser(Map<String, String> parsed) {
        Optional<User> user = getUserByLogin(parsed.get(LOGIN));
        if (!user.isPresent()) {
            return false;
        }

        if (!user.get().getPassword().equals(parsed.get(PASSWORD))) {
            return false;
        }

        return true;
    }

    private Optional<User> getUserByLogin(String login) {
        for(User user: users) {
            if(user.getLogin().equals(login)) {
                return Optional.of(user);
            }
        }

        return Optional.empty();
    }

    protected String getBody(HttpExchange httpExchange) {
        InputStream input = httpExchange.getRequestBody();
        Charset utf8 = StandardCharsets.UTF_8;
        InputStreamReader isr = new InputStreamReader(input, utf8);
        // сейчас мы предполагаем, что клиент
        // отправляет текстовые данные
        try (BufferedReader reader = new BufferedReader(isr)) {
            return reader.lines().collect(joining(""));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    protected void redirect303(HttpExchange exchange, String path) {
        try {
            exchange.getResponseHeaders().add("Location", path);
            exchange.sendResponseHeaders(303, 0);
            exchange.getResponseBody().close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getContentType(HttpExchange httpExchange) {
        return httpExchange.getRequestHeaders()
                .getOrDefault("Content-Type", List.of(""))
                .get(0);
    }

    protected void renderTemplate(HttpExchange exchange, String templateFile,Object dataModel) {
        try {
            // загружаем шаблон из файла по имени.
            // шаблон должен находится по пути, указанном в конфигурации
            Template temp = freemarker.getTemplate(templateFile);

            // freemarker записывает преобразованный шаблон в объект класса writer
            // а наш сервер отправляет клиенту массивы байт
            // по этому нам надо сделать "мост" между этими двумя системами

            // создаём поток который сохраняет всё, что в него будет записано в байтовый массив
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            // создаём объект, который умеет писать в поток и который подходит для freemarker
            try (OutputStreamWriter writer = new OutputStreamWriter(stream)) {

                // обрабатываем шаблон заполняя его данными из модели
                // и записываем результат в объект "записи"
                temp.process(dataModel, writer);
                writer.flush();

                // получаем байтовый поток
                var data = stream.toByteArray();

                // отправляем результат клиенту
                sendByteData(exchange, ResponseCodes.OK, ContentType.TEXT_HTML, data);
            }
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private SampleDataModel getSampleDataModel() {
        // возвращаем экземпляр тестовой модели-данных
        // которую freemarker будет использовать для наполнения шаблона
        return new SampleDataModel();
    }
    private BookDataModel getBookDataModel(){
        return new BookDataModel();
    }
    private User getUserDataModel() {
        return new User();
    }
    private HomePage getHomePageDataModel() {
        return new HomePage();
    }
    private Register getRegisterGetRequest() {
        return new Register();
    }
}