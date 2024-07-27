package com.librarymanager.book;

import com.librarymanager.branch.Branch;
import com.librarymanager.factory.LibraryFactory;
import com.librarymanager.inventory.Inventory;

public class BookUtils {
    public static void generateBooks(Branch branch, LibraryFactory factory) {
        Inventory inventory = branch.getInventory();
        for (int i = 1; i <= 5; i++) {
            Book book = factory.createBook("Book_" + i, "Author_" + i,  2020, 1, new String[]{"Genre " + i, "Genre " + (i+1)});
            inventory.addBook(branch.getBranchId(),book);
        }
    }
}
