package kz.attractor.java.lesson44;


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
        books.add(new Book("«Война и мир»","Лев Толстой","Роман","Good"));
        books.add(new Book("«Улисс»","Джеймс Джойс","Модернизм","Good"));
        books.add(new Book("«Лолита»","Владимир Набоков","Роман","Bad"));
        books.add(new Book("«Звук и ярость»","Уильям Фолкнер","Южная готика","Normal"));
    }
    public class Book{
        private String name;
        private String author;
        private String genre;
        private String status;

        public Book(String name, String author, String genre, String status) {
            this.name = name;
            this.author = author;
            this.genre = genre;
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

        public String getGenre() {
            return genre;
        }

        public void setGenre(String genre) {
            this.genre = genre;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

