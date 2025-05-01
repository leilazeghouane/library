package src;

public class PaperbackBook extends Book {
    private int numberOfPages;

    // Constructor
    public PaperbackBook(String title, String author, String isbn, int numberOfPages) {
        super(title, author, isbn, "Paperback");
        this.numberOfPages = numberOfPages;
    }

    // Getter
    public int getNumberOfPages() {
        return numberOfPages;
    }

    // Override display method to include number of pages
    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("Number of Pages: " + numberOfPages);
    }
}
