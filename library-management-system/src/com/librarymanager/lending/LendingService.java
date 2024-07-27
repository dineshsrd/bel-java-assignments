package com.librarymanager.lending;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.librarymanager.book.Book;
import com.librarymanager.branch.Branch;
import com.librarymanager.patron.Patron;

public class LendingService {
    private final List<Lending> lendingList = new ArrayList<>();
    private final Branch branch;

    public LendingService(Branch branch) {
        this.branch = branch;
    }

    public void checkoutBook(Book book, Patron patron, String checkoutDate) {
        if (book.isBookAvailable()) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            Lending lendingData = new Lending(book, this.branch, patron, checkoutDate);
            lendingList.add(lendingData);
            branch.getInventory().addBorrowing(patron.getPatronId(), book);
            patron.addToBorrowingHistory(book.getIsbn(), lendingData);
        } else {
            System.out.println("Book is not available for checkout");
        }
    }

    public void returnBook(Book book, Patron patron, String returnDate) {
        Optional<Lending> lendingOpt = lendingList.stream().filter(l -> l.getBook().getIsbn().equals(book.getIsbn()) && l.getReturnDate() == null && l.getPatron().getPatronId().equals(patron.getPatronId())).findFirst();
        lendingOpt.ifPresent(lending -> {
            lending.getBook().setAvailableCopies(lending.getBook().getAvailableCopies() + 1);
            lending.setReturnDate(returnDate);
            branch.getInventory().removeBorrowing(patron.getPatronId(),book);
            patron.removeFromBorrowingHistory(book.getIsbn());
        });
    }

    public List<Lending> getAllLendings() {
        return lendingList;
    }
}

