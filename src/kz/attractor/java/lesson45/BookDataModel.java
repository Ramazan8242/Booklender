package kz.attractor.java.lesson45;


import java.util.ArrayList;
import java.util.List;

public class BookDataModel {
    private List<Book> books = new ArrayList<>();

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public BookDataModel() {
        books.add(new Book("«Война и мир»","Лев Толстой","Good"));
        books.add(new Book("«Улисс»","Джеймс Джойс","Good"));
        books.add(new Book("«Лолита»","Владимир Набоков","Bad"));
        books.add(new Book("«Звук и ярость»","Уильям Фолкнер","Normal"));
    }
    public class Book{
        private String name;
        private String author;
        private String status;

        public Book(String name, String author, String status) {
            this.name = name;
            this.author = author;
            this.status = status;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

