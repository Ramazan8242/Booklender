package kz.attractor.java.lesson45;


import kz.attractor.java.server.Utils;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class Cookie {
    private Integer value;
    private String name;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Cookie of(String name, Integer value) {
        Cookie cookie = new Cookie();

        cookie.setValue(value);
        cookie.setName(name);

        return cookie;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Charset utf8 = StandardCharsets.UTF_8;
        String encName = URLEncoder.encode(getName().strip(),
                utf8);
        String stringValue = getValue().toString();
        String encValue = URLEncoder.encode(stringValue, utf8);
        sb.append(String.format("%s=%s", encName,
                encValue));
//            if (getMaxAge() != null) {
//                sb.append(String.format("; Max-Age=%s", getMaxAge()));
//            }
//
//            if (isHttpOnly()) {
//                sb.append("; HttpOnly");
//            }
        return sb.toString();
    }

    public static Map<String, String> parse(String cookie) {
        return Utils.parseUrlEncoded(cookie, ";");
    }
}

