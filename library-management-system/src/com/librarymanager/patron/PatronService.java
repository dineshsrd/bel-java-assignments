package com.librarymanager.patron;

import java.util.HashMap;
import java.util.Map;

public class PatronService {
    private Map<Long, Patron> patrons = new HashMap<>();

    public void addPatron(Patron patron) {
        if (patrons.containsKey(patron.getPatronId())) {
            System.out.println("Patron already exists");
            updatePatron(patron.getPatronId(), patron);
        }else {
            patrons.put(patron.getPatronId(), patron);
            System.out.println("Patron added successfully");
        }
    }

    public void removePatron(Long patronId) {
        if (patrons.containsKey(patronId)) {
            patrons.remove(patronId);
            System.out.println("Patron removed successfully");

        }else{
            System.out.println("Patron not found");
        }
    }

    public Patron getPatron(Long patronId) {
        return patrons.get(patronId);
    }

    public Map<Long, Patron> getAllPatrons() {
        return patrons;
    }

    public void setPatrons(Map<Long, Patron> patrons) {
        this.patrons = patrons;
    }

    public void updatePatron(Long patronId, Patron patron) {
        if (patrons.containsKey(patronId)) {
            patrons.put(patronId, patron);
            System.out.println("Patron updated successfully");
        }else {
            System.out.println("Patron not found");
        }
    }
}
