package com.library.lab04;

public class EBook extends LibraryItem implements DigitalContent, Taxable {
    private String downloadUrl;
    private double fileSize;

    public EBook(String title, String author, String isbn, String downloadUrl, double fileSize) {
        super(title, author, isbn, 99.0, "Available");
        this.downloadUrl = downloadUrl;
        this.fileSize = fileSize;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public double calculateLateFee(int days) {
        return 0.0;
    }

    @Override
    public void displayDetails() {
        System.out.println("Title: " + this.title);
        System.out.println("Author: " + this.author);
        System.out.println("ISBN: " + this.isbn);
        System.out.println("Status: " + this.status);
        if (this.returnDueDate != null) {
            System.out.println("Return Due Date: " + this.returnDueDate);
        } else {
            System.out.println("Return Due Date: N/A (Item is available)");
        }
        System.out.println();
    }

    @Override
    public void printSummary() {
        System.out.printf("EBook [Title='%s', Size='%.2f MB', Status='%s']\n", this.title, this.fileSize, this.status);
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming '" + this.title + "' from URL: " + this.downloadUrl);
        System.out.println("Starting online stream... connected!");
        System.out.println("You can now read the book online without downloading.");
    }

    @Override
    public void download() {
        System.out.println("Downloading '" + this.title + "' from URL: " + this.downloadUrl);
        System.out.printf("Downloading file... (%.2f MB)\n", this.fileSize);
        System.out.println("Download complete! File saved to your device.");
        System.out.println("You can now read the book offline.");
    }

    @Override
    public double calculateTax() {
        double standardEBookPrice = 99.0;
        double digitalTaxRate = 0.05;
        return standardEBookPrice * digitalTaxRate;
    }
}