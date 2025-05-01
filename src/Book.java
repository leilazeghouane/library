package src;

public class Book implements Searchable {
    private String title;
    private String author;
    private String isbn;
    private boolean isBorrowed; // true if borrowed, false if available
    private String type; // e.g., "Paperback", "Ebook"

    // Constructor
    public Book(String title, String author, String isbn, String type) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isBorrowed = false; // Initially, a new book is available
        this.type = type;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setBorrowed(boolean borrowed) {
        isBorrowed = borrowed;
    }

    // Method to display book information
    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Status: " + (isBorrowed ? "Borrowed" : "Available"));
        System.out.println("Type: " + type);
    }

    @Override
    public boolean matches(String query) {
        return this.title.equalsIgnoreCase(query) || this.isbn.equalsIgnoreCase(query);
    }
}
