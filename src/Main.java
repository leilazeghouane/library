package src;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static Library library = new Library();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addBorrower();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    searchBookOrBorrower();
                    break;
                case 6:
                    displayBorrowedBooks();
                    break;
                case 0:
                    System.out.println("Exiting Library Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- Library Management System Menu ---");
        System.out.println("1. Add Book");
        System.out.println("2. Add Borrower");
        System.out.println("3. Borrow Book");
        System.out.println("4. Return Book");
        System.out.println("5. Search Book or Borrower");
        System.out.println("6. Display Borrowed Books by Borrower");
        System.out.println("0. Exit");
        System.out.println("--------------------------------------");
    }

    private static void addBook() {
        System.out.println("\n--- Add New Book ---");
        System.out.print("Enter Title: ");
        String title = scanner.nextLine();
        System.out.print("Enter Author: ");
        String author = scanner.nextLine();
        System.out.print("Enter ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter Type (e.g., Paperback, Ebook): ");
        String type = scanner.nextLine();

        Book newBook = new Book(title, author, isbn, type);
        library.addBook(newBook);
    }

    private static void addBorrower() {
        System.out.println("\n--- Add New Borrower ---");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter University ID: ");
        String universityId = scanner.nextLine();

        Borrower newBorrower = new Borrower(name, universityId);
        library.addBorrower(newBorrower);
    }

    private static void borrowBook() {
        System.out.println("\n--- Borrow Book ---");
        System.out.print("Enter ISBN of the book to borrow: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter University ID of the borrower: ");
        String universityId = scanner.nextLine();

        List<Book> booksFound = library.searchBook(isbn);
        List<Borrower> borrowersFound = library.searchBorrower(universityId);

        if (booksFound.isEmpty()) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        if (borrowersFound.isEmpty()) {
            System.out.println("Borrower with University ID " + universityId + " not found.");
            return;
        }

        // Assuming the first result is the intended one for simplicity
        Book bookToBorrow = booksFound.get(0);
        Borrower borrower = borrowersFound.get(0);

        library.borrowBook(bookToBorrow, borrower);
    }

    private static void returnBook() {
        System.out.println("\n--- Return Book ---");
        System.out.print("Enter ISBN of the book to return: ");
        String isbn = scanner.nextLine();
        System.out.print("Enter University ID of the borrower: ");
        String universityId = scanner.nextLine();

        List<Book> booksFound = library.searchBook(isbn);
        List<Borrower> borrowersFound = library.searchBorrower(universityId);

        if (booksFound.isEmpty()) {
            System.out.println("Book with ISBN " + isbn + " not found.");
            return;
        }
        if (borrowersFound.isEmpty()) {
            System.out.println("Borrower with University ID " + universityId + " not found.");
            return;
        }

        // Assuming the first result is the intended one for simplicity
        Book bookToReturn = booksFound.get(0);
        Borrower borrower = borrowersFound.get(0);

        library.returnBook(bookToReturn, borrower);
    }

    private static void searchBookOrBorrower() {
        System.out.println("\n--- Search ---");
        System.out.print("Enter search query (Title, ISBN, Borrower Name, or University ID): ");
        String query = scanner.nextLine();

        List<Book> bookResults = library.searchBook(query);
        List<Borrower> borrowerResults = library.searchBorrower(query);

        if (bookResults.isEmpty() && borrowerResults.isEmpty()) {
            System.out.println("No books or borrowers found matching the query.");
        } else {
            if (!bookResults.isEmpty()) {
                System.out.println("\n--- Book Search Results ---");
                for (Book book : bookResults) {
                    book.displayBookInfo();
                    System.out.println("---");
                }
            }
            if (!borrowerResults.isEmpty()) {
                System.out.println("\n--- Borrower Search Results ---");
                for (Borrower borrower : borrowerResults) {
                    borrower.displayBorrowerInfo();
                    System.out.println("---");
                }
            }
        }
    }

    private static void displayBorrowedBooks() {
        System.out.println("\n--- Display Borrowed Books by Borrower ---");
        System.out.print("Enter University ID of the borrower: ");
        String universityId = scanner.nextLine();

        List<Borrower> borrowersFound = library.searchBorrower(universityId);

        if (borrowersFound.isEmpty()) {
            System.out.println("Borrower with University ID " + universityId + " not found.");
            return;
        }

        // Assuming the first result is the intended one for simplicity
        Borrower borrower = borrowersFound.get(0);
        library.displayBorrowedBooks(borrower);
    }
}
