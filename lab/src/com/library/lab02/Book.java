package src.com.library.lab02;
import java.time.LocalDate;

public class Book {
    private String title;
    private String author;
    private String isbn;
    private double price;
    private String status;
    private LocalDate returnDueDate;
    private Member currentHolder;

    public Book(String title, String author, String isbn, double price, String status) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getReturnDueDate() {
        return returnDueDate;
    }

    public void setReturnDueDate(LocalDate returnDueDate) {
        this.returnDueDate = returnDueDate;
    }

    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Price: " + price + " Baht");
        System.out.println("Status: " + status);

        if (returnDueDate != null) {
            System.out.println("Return Due Date: " + returnDueDate);
        } else {
            System.out.println("Return Due Date: N/A (Book is available)");
        }
        System.out.println();
    }

    public void returnBook() {
        this.status = "Available";
        this.returnDueDate = null;

        if (this.currentHolder != null) {
            this.currentHolder.removeBook(this);
            this.currentHolder = null;
        }

        System.out.println("Book '" + title + "' has been returned successfully.");
    }
    public void checkOut(Member borrower) {
        if ("Borrowed".equalsIgnoreCase(this.status)){
            System.out.println("Error: Book '" + this.title + "' is already borrowed and cannot be checked out again.");
            return;
        }

        if (!borrower.canBorrow()) {
            System.out.println("Member " + borrower.getName() + " has reached the borrow limit (3).");
            System.out.println("Borrow request denied for member " + borrower.getName() + ".");
            return;
        }
        this.status = "Borrowed";
        this.currentHolder = borrower;
        borrower.addBook(this);
        this.returnDueDate = LocalDate.now().plusDays(14);
        System.out.println("Book '" + title + "' has been checked out successfully.");
        System.out.println("Book " + title + " has been borrowed by " + borrower.getName() + ".");
        System.out.println("Return Due Date: " + this.returnDueDate);
    }

    public void printSummary() {
        System.out.println("Book [Title='" + title + "', Status='" + status + "']");
    }
}
