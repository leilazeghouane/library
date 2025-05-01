package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Library {
    private List<Book> books;
    private List<Borrower> borrowers;
    private List<BorrowingProcess> borrowingProcesses;

    // Constructor
    public Library() {
        this.books = new ArrayList<>();
        this.borrowers = new ArrayList<>();
        this.borrowingProcesses = new ArrayList<>();
    }

    // Method to add a new book
    public void addBook(Book book) {
        if (book != null) {
            this.books.add(book);
            System.out.println("Book added: " + book.getTitle());
        }
    }

    // Method to add a new borrower
    public void addBorrower(Borrower borrower) {
        if (borrower != null) {
            this.borrowers.add(borrower);
            System.out.println("Borrower added: " + borrower.getName());
        }
    }

    // Method to borrow a book
    public void borrowBook(Book book, Borrower borrower) {
        if (book != null && borrower != null) {
            if (!book.isBorrowed()) {
                book.setBorrowed(true);
                borrower.addBorrowedBook(book);
                BorrowingProcess process = new BorrowingProcess(book, borrower);
                this.borrowingProcesses.add(process);
                System.out.println("Book '" + book.getTitle() + "' borrowed by " + borrower.getName());
            } else {
                System.out.println("Book '" + book.getTitle() + "' is already borrowed.");
            }
        } else {
            System.out.println("Invalid book or borrower.");
        }
    }

    // Method to return a book
    public void returnBook(Book book, Borrower borrower) {
        if (book != null && borrower != null) {
            if (book.isBorrowed() && borrower.getBorrowedBooks().contains(book)) {
                book.setBorrowed(false);
                borrower.removeBorrowedBook(book);
                // Find the corresponding borrowing process and set return date
                for (BorrowingProcess process : borrowingProcesses) {
                    if (process.getBook().equals(book) && process.getBorrower().equals(borrower) && process.getReturnDate() == null) {
                        process.setReturnDate(new Date());
                        break;
                    }
                }
                System.out.println("Book '" + book.getTitle() + "' returned by " + borrower.getName());
            } else {
                System.out.println("Book '" + book.getTitle() + "' was not borrowed by " + borrower.getName() + " or is not currently borrowed.");
            }
        } else {
            System.out.println("Invalid book or borrower.");
        }
    }

    // Method to search for a book by title or ISBN
    public List<Book> searchBook(String query) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.matches(query)) {
                results.add(book);
            }
        }
        return results;
    }

    // Method to search for a borrower by name or university ID
    public List<Borrower> searchBorrower(String query) {
        List<Borrower> results = new ArrayList<>();
        for (Borrower borrower : borrowers) {
            if (borrower.matches(query)) {
                results.add(borrower);
            }
        }
        return results;
    }

    // Method to display books borrowed by a specific borrower
    public void displayBorrowedBooks(Borrower borrower) {
        if (borrower != null) {
            borrower.displayBorrowerInfo();
        } else {
            System.out.println("Invalid borrower.");
        }
    }

    // Getters for collections (for potential future use or testing)
    public List<Book> getBooks() {
        return books;
    }

    public List<Borrower> getBorrowers() {
        return borrowers;
    }

    public List<BorrowingProcess> getBorrowingProcesses() {
        return borrowingProcesses;
    }
}
