package com.librarymanager.branch;

import com.librarymanager.book.Book;
import com.librarymanager.factory.LibraryFactory;
import com.librarymanager.patron.Patron;

public class BranchFactory implements LibraryFactory {
    @Override
    public Book createBook(String title, String author, int publicationYear, int availableCopies, String[] genres) {
        throw new RuntimeException("Can be used only for creating Branch");
    }

    @Override
    public Patron createPatron(String name, String email, String phone) {
        throw new RuntimeException("Can be used only for creating Branch");
    }

    @Override
    public Branch createBranch(String name, String address, String phone) {
        return new Branch(name, address, phone);
    }
}
