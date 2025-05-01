package src;

import java.util.Date;

public class BorrowingProcess {
    private Book book;
    private Borrower borrower;
    private Date borrowDate;
    private Date returnDate; // Null if not yet returned

    // Constructor
    public BorrowingProcess(Book book, Borrower borrower) {
        this.book = book;
        this.borrower = borrower;
        this.borrowDate = new Date(); // Set borrow date to current date
        this.returnDate = null; // Initially, return date is null
    }

    // Getters
    public Book getBook() {
        return book;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    // Setter for return date
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Method to display borrowing process information
    public void displayProcessInfo() {
        System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
        System.out.println("Borrower: " + borrower.getName());
        System.out.println("Borrow Date: " + borrowDate);
        if (returnDate != null) {
            System.out.println("Return Date: " + returnDate);
        } else {
            System.out.println("Status: Not yet returned");
        }
    }
}
