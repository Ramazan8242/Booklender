package kz.attractor.java;

import kz.attractor.java.lesson45.Lesson45Server;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            new Lesson45Server("localhost", 9988).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
