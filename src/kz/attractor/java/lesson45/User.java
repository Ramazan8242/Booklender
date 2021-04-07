package kz.attractor.java.lesson45;

import java.util.ArrayList;
import java.util.List;

//public class UserDataModel {
//    private User user = new User("Apache", "FreeMarker");
//    private List<User> customers = new ArrayList<>();


//    public UserDataModel() {
//        customers.add(new User("Марко","Война и мир","Лолита"));
//        customers.add(new User("Винстон", "Лолита","Война и мир"));
//        customers.add(new User("Амос", "Звук и ярость", "'Улисс'"));
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//    public List<User> getCustomers() {
//        return customers;
//    }
//
//    public void setCustomers(List<User> customers) {
//        this.customers = customers;
//    }

    public class User {
        private String name;
        private String email;
        private String login;
        private String password;

        private List<User> customers = new ArrayList<>();

        public User() {
        customers.add(new User("Марко","Marco Marco@test.mail","Marco","897858"));
        customers.add(new User("Винстон", "Winston Winston@test.mail","Winston","979735834"));
        customers.add(new User("Амос", "Amos Amos@test.mail", "Amos","42635753"));
    }

        public User(String name, String email, String login, String password) {
            this.name = name;
            this.email = email;
            this.login = login;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getLogin() {
            return login;
        }

        public void setLogin(String login) {
            this.login = login;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
//}
