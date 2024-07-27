package com.librarymanager.patron;

import com.librarymanager.book.Book;
import com.librarymanager.branch.Branch;
import com.librarymanager.factory.LibraryFactory;

public class PatronFactory implements LibraryFactory {
    @Override
    public Book createBook(String title, String author, int publicationYear, int availableCopies, String[] genres) {
        throw new RuntimeException("Can be used only for creating Patron");
    }

    @Override
    public Patron createPatron(String name, String email, String phone) {
        return new Patron(name, email, phone);
    }

    @Override
    public Branch createBranch(String name, String address, String phone) {
        throw new RuntimeException("Can be used only for creating Patron");
    }
}
