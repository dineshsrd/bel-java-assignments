package com.librarymanager.book;

import java.util.Arrays;

public class Book {
    //java 17 records
    private final Long bookId;
    private final String title;
    private final String isbn;
    private final String author;
    private final int publicationYear;
    private int availableCopies;
    private String branchId;
    private String[] tags;

    protected Book(String title, String author, int publicationYear, int availableCopies, String[] tags) {
        this.bookId = Long.valueOf(title.split("_")[1]);
        this.isbn =  String.valueOf((int)(Math.random() * 100000000));
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.availableCopies = availableCopies;
        this.tags = tags;
    }
    public Book(Book book) {
        this.bookId = book.bookId;
        this.title = book.title;
        this.isbn = book.isbn;
        this.author = book.author;
        this.publicationYear = book.publicationYear;
        this.availableCopies = book.availableCopies;
        this.branchId = book.branchId;
        this.tags = book.tags;
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }


    public String getIsbn() {
        return isbn;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public boolean isBookAvailable() {
        return this.availableCopies > 0;
    }
    @Override
    public String toString() {
        return "\nBook{" +
                "bookId='" + bookId + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author='" + author + '\'' +
                ", publicationYear=" + publicationYear +
                ", availableCopies=" + availableCopies +
                ", branchId='" + branchId + '\'' +
                ", tags=" + Arrays.toString(tags) +
                '}';
    }
}
