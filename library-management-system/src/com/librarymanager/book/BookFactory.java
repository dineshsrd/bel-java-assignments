package com.librarymanager.book;

import com.librarymanager.branch.Branch;
import com.librarymanager.factory.LibraryFactory;
import com.librarymanager.patron.Patron;

public class BookFactory implements LibraryFactory {
    @Override
    public Book createBook(String title, String author, int publicationYear, int availableCopies, String[] genres) {
        return new Book(title, author, publicationYear, availableCopies, genres);
    }

    @Override
    public Patron createPatron(String name, String email, String phone) {
        throw new RuntimeException("Can be used only for creating Book");
    }

    @Override
    public Branch createBranch(String name, String address, String phone) {
        throw new RuntimeException("Can be used only for creating Book");
    }
}
