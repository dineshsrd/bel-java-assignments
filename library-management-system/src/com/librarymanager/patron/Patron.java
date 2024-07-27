package com.librarymanager.patron;

import java.util.HashMap;

import com.librarymanager.book.Book;
import com.librarymanager.lending.Lending;

public class Patron {
    private final Long patronId;
    private String name;
    private String email;
    private String phone;
    private HashMap<String, Lending> borrowingHistory;
    //store notifications of each patron
    protected Patron(String name, String email, String phone) {
        this.patronId = Long.valueOf(name.split("_")[1]);
        this.name = name;
        this.email = email;
        this.phone = phone;
        borrowingHistory = new HashMap<>();
    }

    public Long getPatronId() {
        return patronId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public HashMap<String, Lending> getBorrowingHistory() {
        return borrowingHistory;
    }

    public void addToBorrowingHistory(String isbn, Lending lendingData) {
        borrowingHistory.put(isbn, lendingData);
    }

    public void removeFromBorrowingHistory(String isbn) {
        borrowingHistory.remove(isbn);
    }

    @Override
    public String toString() {
        return "\nPatron{" +
                "patronId=" + getPatronId() +
                ", name='" + getName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", phone='" + getPhone() + '\'' +
                ", borrowingHistory=" + getBorrowingHistory() +
                '}';
    }
}
