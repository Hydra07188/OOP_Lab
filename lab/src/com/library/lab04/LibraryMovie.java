package com.library.lab04;

import java.time.LocalDate;
import java.util.UUID;

public class LibraryMovie implements DigitalContent, Taxable {
    private String title;
    private String director;
    private String streamingUrl;
    private double durationMinutes;
    private int releaseYear;
    private String genre;
    private double price;
    private boolean isAvailable;
    private LocalDate returnDueDate;
    private Member borrowedBy;
    private final String uniqueId;
    private String genrel;

    public LibraryMovie(String uniqueId) {
        this.uniqueId = UUID.randomUUID().toString();
    }

    public LibraryMovie(String title, String director, String streamingUrl, double durationMinutes, int releaseYear, String genre, double price) {
        this("");
        this.title = title;
        this.director = director;
        this.streamingUrl = streamingUrl;
        this.durationMinutes = durationMinutes;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.price = price;
        this.isAvailable = true;
    }

    @Override
    public void streamOnline() {
        System.out.println("Streaming '" + this.title + "' from URL: " + this.streamingUrl);
        System.out.println("Connecting to streaming server...");
        System.out.println("Movie playback started!");
        System.out.printf("Duration: %.0f minutes | Director: %s\n", durationMinutes, director); // เปลี่ยน %.Of เป็น %.0f
        System.out.println("Quality: 1080p HD | Enjoy watching!");
    }

    @Override
    public void download() {
        System.out.println("Downloading '" + this.title + "' from URL: " + this.streamingUrl);
        System.out.println("Calculating file size based on quality...");
        double estimatedSizeMB = (durationMinutes / 60) * 175;
        System.out.printf("Downloading file... (%.2f MB)\n", estimatedSizeMB); // จัด Format ใหม่
        System.out.println("Download complete! File saved to your device.");
        System.out.println("You can now watch the movie offline.");
    }

    @Override
    public double calculateTax() { // ดึงออกมาไม่ให้ซ้อนกับ download()
        return this.price * 0.05; // ภาษี 5% สำหรับ Digital Content
    }


    public String getTitle() { return title; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStreamingUrl() {
        return streamingUrl;
    }

    public void setStreamingUrl(String streamingUrl) {
        this.streamingUrl = streamingUrl;
    }

    public double getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(double durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenrel() {
        return genrel;
    }

    public void setGenrel(String genrel) {
        this.genrel = genrel;
    }

    public double getPrice() { return price; }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public Member getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(Member borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public String getUniqueId() {
        return uniqueId;
    }

}
