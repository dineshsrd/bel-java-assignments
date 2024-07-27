package com.librarymanager.lending;

import com.librarymanager.book.Book;
import com.librarymanager.branch.Branch;
import com.librarymanager.patron.Patron;

public class Lending {
    private final String lendingId;
    private final Book book;
    private final Branch branch;
    private final Patron patron;
    private final String checkoutDate;
    private String returnDate;

    public Lending(Book book, Branch branch, Patron patron, String checkoutDate) {
        this.lendingId = generateLendingId();
        this.book = book;
        this.branch = branch;
        this.patron = patron;
        this.checkoutDate = checkoutDate;
    }

    public String getLendingId() {
        return lendingId;
    }

    public Book getBook() {
        return book;
    }

    public Branch getBranch() {
        return branch;
    }

    public Patron getPatron() {
        return patron;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    private String generateLendingId() {
        return "LEN" + (int) (Math.random() * 1000);
    }

    @Override
    public String toString() {
        return "Lending{" +
                "lendingId='" + lendingId + '\'' +
                ", book=" + book.getIsbn() +
                ", branch=" + branch.getBranchId() +
                ", patron=" + patron.getPatronId() +
                ", checkoutDate='" + checkoutDate + '\'' +
                ", returnDate='" + returnDate + '\'' +
                '}';
    }
}
