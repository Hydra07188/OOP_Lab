package com.library.lab03;

public class EBook extends LibraryItem {
    private String downloadUrl;
    private double fileSize;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, 0.0, "Available");
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    @Override
    public void displayDetails() {
        System.out.println("E-BOOK");
        super.displayDetails();
        System.out.println("Download URL: " + downloadUrl);
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println();
    }

    @Override
    public double calculateLateFee(int days) {
        return 0.0;
    }
}