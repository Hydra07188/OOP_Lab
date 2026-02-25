package src.com.library.lab03;

public class PhysicalBook extends LibraryItem {
    private String shelfLocation;

    public PhysicalBook(String title, String author, String isbn, double price, String shelfLocation) {
        super(title, author, isbn, price, "Available");
        this.shelfLocation = shelfLocation;
    }

    @Override
    public void displayDetails() {
        System.out.println("PHYSICAL BOOK");
        super.displayDetails();
        System.out.println("Shelf Location: " + shelfLocation);
        System.out.println();
    }

    public void printSummary() {
        System.out.println("PhysicalBook [Title='" + title + "', Location='" + shelfLocation + "', Status='" + status + "']");
    }

    @Override
    public double calculateLateFee(int days) {
        return days * 5.0;
    }
}