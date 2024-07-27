package com.librarymanager.factory;

import com.librarymanager.book.Book;
import com.librarymanager.branch.Branch;
import com.librarymanager.patron.Patron;

public interface LibraryFactory {
    Book createBook(String title, String author, int publicationYear, int availableCopies, String[] genres);
    Patron createPatron(String name, String email, String phone);
    Branch createBranch(String name, String address, String phone);
}
