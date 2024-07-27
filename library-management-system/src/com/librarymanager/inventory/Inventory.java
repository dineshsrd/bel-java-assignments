package com.librarymanager.inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.librarymanager.book.Book;
import com.librarymanager.branch.Branch;
import com.librarymanager.lending.Lending;
import com.librarymanager.lending.LendingService;
import com.librarymanager.patron.Patron;

public class Inventory {
    private Map<Long, Book> availableBooks = new HashMap<>(); //BookId, Book
    private Map<Long, List<Book>> borrowedBooks = new HashMap<>(); //PatronId, List of Books
    public void addBook(String branchId, Book book) {
        book.setBranchId(branchId);
        if (!availableBooks.containsKey(book.getBookId())) {
            availableBooks.put(book.getBookId(), book);
            System.out.println("Book added successfully");
        }else{
            availableBooks.get(book.getBookId()).setAvailableCopies(availableBooks.get(book.getBookId()).getAvailableCopies()+1);
            System.out.println("Book already exists. Added one more copy");
        }
    }

    public void removeBook(Long bookId) {
        if (availableBooks.containsKey(bookId)) {
            availableBooks.remove(bookId);
            System.out.println("Book removed successfully");
        }else{
            System.out.println("Book not found");
        }
    }

    public void updateBook(Long bookId, Book book) {
        if (availableBooks.containsKey(bookId)) {
            availableBooks.put(bookId, book);
            System.out.println("Book updated successfully");
        }else{
            System.out.println("Book not found");
        }
    }

    //Use optional to handle null
    public Book getBook(Long bookId) {
        return availableBooks.get(bookId);
    }

    public Map<Long, Book> getAllBooks() {
        return availableBooks;
    }

    //get book by title
    public Book getBookByTitle(String title) {
        for (Book book : availableBooks.values()) {
            if (book.getTitle().equals(title)) {
                return book;
            }
        }
        return null;
    }

    //get book by author
    public Book getBookByAuthor(String author) {
        for (Book book : availableBooks.values()) {
            if (book.getAuthor().equals(author)) {
                return book;
            }
        }
        return null;
    }

    //get book by publication year
    public Book getBookByISBN(String isbn) {
        for (Book book : availableBooks.values()) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    public void addBorrowing(Long patronId, Book borrowedBook) {
        if(this.borrowedBooks.containsKey(patronId)) {
            this.borrowedBooks.get(patronId).add(borrowedBook);
        } else {
            List<Book> books = new ArrayList<>();
            books.add(borrowedBook);
            this.borrowedBooks.put(patronId, books);
        }
    }

    public void removeBorrowing(Long patronId, Book borrowedBook) {
        if(this.borrowedBooks.containsKey(patronId)) {
            List<Book> borrowed = this.borrowedBooks.get(patronId);
            borrowed.remove(borrowedBook);
            this.borrowedBooks.put(patronId, borrowed);
        }
    }

    private String getAvailableBooks() {
        String availableBooksString = "";
        for (Book book : availableBooks.values()) {
            availableBooksString += book.isBookAvailable()? book+"\n" : "";
        }
        return availableBooksString;
    }

    //Move book from one branch to another, update the inventory based on quantity
    public void moveBook(Branch fromBranch, Branch toBranch, Long bookId, int quantity) {
        Book book = fromBranch.getInventory().getBook(bookId);
        Book newBook = new Book(book);
        if (book != null) {
            if (book.getAvailableCopies() >= quantity) {
                book.setAvailableCopies(book.getAvailableCopies() - quantity);
                fromBranch.getInventory().updateBook(bookId, book);
                newBook.setAvailableCopies(quantity);
                toBranch.getInventory().addBook(toBranch.getBranchId(), newBook);
                System.out.println("Book moved successfully");
            } else {
                System.out.println("Not enough copies to move");
            }
        } else {
            System.out.println("Book not found");
        }
    }

    @Override
    public String toString() {
        return "\n\n=======Inventory======\n" +
                "\n=========availableBooks=========\n" + getAvailableBooks() +
                "\n=========borrowedBooks==========\n" + borrowedBooks.toString();
    }
}
