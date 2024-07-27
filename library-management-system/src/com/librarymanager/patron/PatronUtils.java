package com.librarymanager.patron;

import java.util.HashMap;
import java.util.Map;

import com.librarymanager.factory.LibraryFactory;

public class PatronUtils {
    public static Map<Long, Patron> generatePatrons(PatronService patronService, LibraryFactory factory) {
        Map<Long, Patron> patrons = new HashMap<>();
        for (int i = 1; i <= 5; i++) {
            Patron patron = factory.createPatron("Patron_" + i, "patron_" + i + "@gmail.com", "1234567890");
            patronService.addPatron(patron);
        }
        return patrons;
    }
    //get patron using ID and display all data
}
