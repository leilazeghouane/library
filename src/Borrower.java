package src;

import java.util.ArrayList;
import java.util.List;

public class Borrower implements Searchable {
    private String name;
    private String universityId;
    private List<Book> borrowedBooks;

    // Constructor
    public Borrower(String name, String universityId) {
        this.name = name;
        this.universityId = universityId;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getUniversityId() {
        return universityId;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // Method to add a borrowed book
    public void addBorrowedBook(Book book) {
        if (book != null) {
            this.borrowedBooks.add(book);
        }
    }

    // Method to remove a returned book
    public void removeBorrowedBook(Book book) {
        if (book != null) {
            this.borrowedBooks.remove(book);
        }
    }

    // Method to display borrower information
    public void displayBorrowerInfo() {
        System.out.println("Name: " + name);
        System.out.println("University ID: " + universityId);
        System.out.println("Borrowed Books:");
        if (borrowedBooks.isEmpty()) {
            System.out.println("  No books borrowed.");
        } else {
            for (Book book : borrowedBooks) {
                System.out.println("  - " + book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    @Override
    public boolean matches(String query) {
        return this.name.equalsIgnoreCase(query) || this.universityId.equalsIgnoreCase(query);
    }
}
