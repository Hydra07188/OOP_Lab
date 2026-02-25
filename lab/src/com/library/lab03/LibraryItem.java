package com.library.lab03;
import java.time.LocalDate;

public class LibraryItem {

    protected String title;
    protected String author;
    protected String isbn;
    protected double price;
    protected String status;
    protected LocalDate returnDueDate;
    protected Member currentHolder;

    public LibraryItem(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
    }

    public String getTitle() { return title; }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        if (price > 0) {
            System.out.println("Price: " + price + " Baht");
        }
        System.out.println("Status: " + status);

        if (returnDueDate != null) {
            System.out.println("Return Due Date: " + returnDueDate);
        } else {
            System.out.println("Return Due Date: N/A (Item is available)");
        }
    }

    public double calculateLateFee(int days) {
        return 0.0;
    }

    public void returnItem() {
        this.status = "Available";
        this.returnDueDate = null;
        if (this.currentHolder != null) {
            this.currentHolder.removeItem(this);
            this.currentHolder = null;
        }
        System.out.println("Item '" + title + "' has been returned successfully.");
    }

    public void checkOut(Member borrower) {
        if ("Borrowed".equalsIgnoreCase(this.status)){
            System.out.println("Error: Item '" + this.title + "' is already borrowed and cannot be checked out again.");
            return;
        }
        if (!borrower.canBorrow()) {
            System.out.println("Member " + borrower.getName() + " has reached the borrow limit.");
            return;
        }
        this.status = "Borrowed";
        this.currentHolder = borrower;
        borrower.addItem(this);
        this.returnDueDate = LocalDate.now().plusDays(14);
        System.out.println("Item '" + title + "' has been checked out successfully.");
        System.out.println("Item '" + title + "' has been borrowed by " + borrower.getName() + ".");
        System.out.println("Return Due Date: " + this.returnDueDate);
    }
}