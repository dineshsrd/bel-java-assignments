package com.librarymanager;

import java.util.Map;

import com.librarymanager.book.Book;
import com.librarymanager.book.BookUtils;
import com.librarymanager.branch.Branch;
import com.librarymanager.book.BookFactory;
import com.librarymanager.branch.BranchFactory;
import com.librarymanager.factory.LibraryFactory;
import com.librarymanager.inventory.Inventory;
import com.librarymanager.lending.LendingService;
import com.librarymanager.patron.Patron;
import com.librarymanager.patron.PatronFactory;
import com.librarymanager.patron.PatronService;
import com.librarymanager.patron.PatronUtils;

public class RunLibrary {

    static {
        System.out.println("Running Library Manager...");
    }

    public static void main(String[] args) {

        LibraryFactory bookFactory = new BookFactory();
        LibraryFactory patronFactory = new PatronFactory();
        LibraryFactory branchFactory = new BranchFactory();

        // Create branches
        Branch branch = branchFactory.createBranch("Branch 1", "Address 1", "1234567890");
        Branch branch2 = branchFactory.createBranch("Branch 2", "Address 2", "0987654321");

        // Generate books for the branch
        BookUtils.generateBooks(branch, bookFactory);
        Inventory inventory = branch.getInventory();
        Map<Long, Book> books = inventory.getAllBooks();
        System.out.println("All Books in Branch 1:");
        System.out.println(books);
        System.out.println();

        // Display details of a specific book
        Book book = inventory.getBook(2L);
        System.out.println("Details of Book with ID 2:");
        System.out.println(book);
        System.out.println();

        // Initialize Patron Service and generate patrons
        PatronService patronService = new PatronService();
        PatronUtils.generatePatrons(patronService, patronFactory);
        Map<Long, Patron> patronMap = patronService.getAllPatrons();
        Patron p1 = patronService.getPatron(1L);
        System.out.println("Details of Patron with ID 1:");
        System.out.println(p1);
        System.out.println();

        // Set up Lending Service and process book checkout
        LendingService lendingService = new LendingService(branch);
        branch.setLendingService(lendingService);
        lendingService.checkoutBook(book, p1, "2024-07-01");
        System.out.println("Lending Details:");
        System.out.println(lendingService.getAllLendings());
        System.out.println(p1);
        System.out.println(book);
        System.out.println(inventory);

        System.out.println("\n\n\n==================== AFTER RETURNING =====================\n\n\n");

        // Uncomment to test returning books and moving between branches
        // lendingService.returnBook(book, p1, "2024-07-10");
        // inventory.moveBook(branch, branch2, 2L, 1);
        System.out.println("Branch 1 Details:");
        System.out.println(branch);
        System.out.println("Branch 2 Details:");
        System.out.println(branch2);
        System.out.println("All Lendings:");
        System.out.println(lendingService.getAllLendings());
        System.out.println("Updated Patron Details:");
        System.out.println(p1);
        System.out.println("Updated Book Details:");
        System.out.println(book);
        System.out.println("Updated Inventory:");
        System.out.println(inventory);
    }
}
