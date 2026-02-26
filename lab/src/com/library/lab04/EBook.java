package com.library.lab04;

public class EBook extends LibraryItem implements DigitalContent, Taxable{
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

    @Override
    public void streamOnline() {

    }

    @Override
    public void downlond() {

    }

    @Override
    public double calcuateTax() {
        double standardE
    }
}