package kz.attractor.java.lesson44;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BookModel {
    private BookModel.Book book = new BookModel.Book("Apache", "FreeMarker");
    private LocalDateTime currentDateTime = LocalDateTime.now();
    private List<BookModel.Book> bookList = new ArrayList<>();

    public BookModel() {
        bookList.add(new BookModel.Book("Война и мир"));
        bookList.add(new BookModel.Book("1984"));
        bookList.add(new BookModel.Book("Улисс"));
        bookList.add(new BookModel.Book("Лолита"));
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public static class Book {
        private String booksName;
        private String author;

        public Book(String booksName) {
            this.booksName = booksName;
        }
        public Book(String booksName, String author) {
            this.booksName = booksName;
            this.author = author;
        }


        public String getName() {
            return booksName;
        }

        public void setName(String booksName) {
            this.booksName = booksName;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }
    }
}
