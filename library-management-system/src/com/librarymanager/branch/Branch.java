package com.librarymanager.branch;

import java.util.List;
import java.util.Map;

import com.librarymanager.book.Book;
import com.librarymanager.inventory.Inventory;
import com.librarymanager.lending.Lending;
import com.librarymanager.lending.LendingService;

public class Branch {
    private final String branchId;
    private final String name;
    private final String address;
    private final String phone;
    private Inventory inventory;
    private LendingService lendingService;

    protected Branch(String name, String address, String phone) {
        this.branchId = generateId();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new Inventory();
    }

    public String getBranchId() {
        return branchId;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public List<Lending> getLendingHistory() {
        return this.lendingService.getAllLendings();
    }

    public void setLendingService(LendingService lendingService) {
        this.lendingService = lendingService;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private String generateId() {
        return "BRANCH_" + (int) (Math.random() * 1000);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchId='" + branchId + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", inventory=" + inventory.toString() +
                ", lendingService=" + this.getLendingHistory() +
                '}';
    }
}
