package com.wordpress.medicourses.medibasics;

public class Book {

    private final int bookimg;
    private final String booktitle;
    private final String booksrc;
    private final int bookid;

    public Book(int bookimg, String booktitle, String booksrc, int bookid) {

        this.bookimg = bookimg;
        this.booktitle = booktitle;
        this.booksrc = booksrc;
        this.bookid = bookid;
    }

    public int getBookimg() {
        return bookimg;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public String getBooksrc() {
        return booksrc;
    }

    public int getBookid() {
        return bookid;
    }
}
