package com.library.lab05;


import java.time.LocalDate;
import java.util.UUID;

/**
 * LibraryItem - Base class for all library items
 * Contains common attributes and behaviors for all items in the library
 */
public abstract class LibraryItem {
    // Common Attributes
    protected String title;
    protected String isbn;
    protected boolean isAvailable;
    protected LocalDate returnDueDate;
    protected Member borrowedBy;
    protected final String uniqueId;
    protected double price;
    // Constructor
    public LibraryItem(String title, String isbn, double price) {
        this.title = title;
        this.isbn = isbn;
        this.isAvailable = true;
        this.returnDueDate = null;
        this.borrowedBy = null;
        this.price = price;
        this.uniqueId = UUID.randomUUID().toString();
    }
    // Getters
    public String getTitle() {
        return title;
    }
    public String getIsbn() {
        return isbn;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getUniqueId() {
        return uniqueId;
    }
    public Member getBorrowedBy() {
        return borrowedBy;
    }
    // Common Methods
    public void checkOut(Member borrower) {
        if (borrower == null) {
            System.out.println(" Error: A valid member is required to borrow an item.");
            return;
        }
        if (!isAvailable) {
            System.out.println(" Error: Item '" + this.title + "' is already borrowed and cannot be checked out again.");
            return;
        }
        if (!borrower.canBorrow(this)) {
            System.out.println(" Borrow request denied for member " +
                    borrower.getMemberName() + ".");
            return;
        }
// STRATEGY PATTERN: Get loan period from member's strategy!
        int loanPeriod = borrower.getMembershipStrategy().getLoanPeriodDays();
        this.isAvailable = false;
        this.returnDueDate = LocalDate.now().plusDays(loanPeriod);
        this.borrowedBy = borrower;
        borrower.recordBorrow(this);
        System.out.println(" ✅ Item '" + this.title + "' has been checked out successfully.");
        System.out.printf(" 📖 Borrowed by %s (%s)\n", borrower.getMemberName(), borrower.getMembershipStrategy().getMembershipType());
        System.out.println(" 📅 Loan Period: " + loanPeriod + " days");
        System.out.println(" 📅 Return Due Date: " + this.returnDueDate);
    }
    public void returnItem() {
        if (isAvailable) {
            System.out.println(" Error: Item '" + this.title + "' is already available.");
            return;
        }
        this.isAvailable = true;
        this.returnDueDate = null;
        if (this.borrowedBy != null) {this.borrowedBy.recordReturn(this);
        }
        this.borrowedBy = null;
        System.out.println(" Item '" + this.title + "' has been returned successfully.");
    }
    /**
     * Display details - to be overridden by subclasses for polymorphism
     */
    public void displayDetails() {
        System.out.println(" - Title: " + this.title);
        System.out.println(" - ISBN: " + this.isbn);
        System.out.println(" - Status: " + (this.isAvailable ? "Available" : "Borrowed"));
        if (this.returnDueDate != null) {
            System.out.println(" - Return Due Date: " + this.returnDueDate);
        } else {
            System.out.println(" - Return Due Date: N/A (Item is available)");
        }
        System.out.println();
    }
    public void printSummary() {
        System.out.printf("LibraryItem[Title='%s', Status='%s']\n", title, isAvailable ? "Available" : "Borrowed");
    }
    /**
     * Calculate late fee for overdue items
     * Base implementation - to be overridden by subclasses
     * Demonstrates METHOD OVERRIDING with specialized behavior
     *
     * @param daysLate number of days the item is late
     * @return late fee amount in Baht
     */
    public abstract double calculateLateFee(int daysLate);
}