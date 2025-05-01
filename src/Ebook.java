package src;

public class Ebook extends Book {
    private double fileSizeMB;

    // Constructor
    public Ebook(String title, String author, String isbn, double fileSizeMB) {
        super(title, author, isbn, "Ebook");
        this.fileSizeMB = fileSizeMB;
    }

    // Getter
    public double getFileSizeMB() {
        return fileSizeMB;
    }

    // Override display method to include file size
    @Override
    public void displayBookInfo() {
        super.displayBookInfo();
        System.out.println("File Size (MB): " + fileSizeMB);
    }
}
