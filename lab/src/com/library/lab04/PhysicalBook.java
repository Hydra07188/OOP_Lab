package com.library.lab04;

public class PhysicalBook extends LibraryItem implements Taxable {
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price, "Available");
        this.shelfLocation = shelfLocation;
    }

    public String getShelfLocation() {
        return shelfLocation;
    }

    public void setShelfLocation(String shelfLocation) {
        this.shelfLocation = shelfLocation;
    }

    @Override
    public double calculateLateFee(int days) {
        return days * 5.0; // ค่าปรับ 5 บาทต่อวัน
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        if (this.price > 0) {
            System.out.println("Price: " + this.price + " Baht");
        }

        System.out.println("Shelf Location: " + this.shelfLocation);

        System.out.println("Status: " + this.status);
        if (this.returnDueDate != null) {
            System.out.println("Return Due Date: " + this.returnDueDate);
        } else {
            System.out.println("Return Due Date: N/A (Book is available)");
        }
        System.out.println();
    }

    public void printSummary() {
        System.out.println("PhysicalBook [Title='" + title + "', Location='" + shelfLocation + "', Status='" + status + "']");
    }

    @Override
    public double calculateTax() {
        double taxRate = 0.07;
        return this.getPrice() * taxRate;
    }
}