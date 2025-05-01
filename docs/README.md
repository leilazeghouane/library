# Simple Digital Library Management System

## Project Description
This project is a simple digital library management system developed in Java. The system is designed to manage books, borrowers, and the processes of borrowing and returning books. It features a text-based console interface for user interaction.

## Objectives
- Apply Object-Oriented Programming (OOP) concepts: Classes, Encapsulation, Inheritance, Polymorphism, and Interfaces.
- Use Git and GitHub for version control.
- Develop problem-solving and logical thinking skills.

## Project Requirements
- **Classes and Objects:**
    - `Book`: Represents a book with title, author, ISBN, status (borrowed/available), and type (paperback/ebook).
    - `Borrower`: Represents a borrower with name, university ID, and a list of borrowed books.
    - `BorrowingProcess`: Represents a borrowing transaction with book, borrower, borrow date, and return date.
- **Functionalities:**
    - Add new book.
    - Add new borrower.
    - Borrow a book to a borrower.
    - Return a book from a borrower.
    - Search for a book or borrower.
    - Display books borrowed by a specific borrower.
- **User Interface:**
    - Simple console application.
- **Version Control:**
    - Use Git for managing project versions and push to a GitHub repository.
    - Create commits for each feature or modification.
- **Documentation:**
    - Document code using comments.
    - Create a `README.md` file explaining the project and how to run it.

## How to Run the Project

1. **Prerequisites:**
   - Java Development Kit (JDK) installed.
   - Git installed.

2. **Clone the Repository:**
   ```bash
   git clone <https://github.com/zeghouaneleila>

   ```

3. **Compile the Code:**
   Navigate to the project's root directory in your terminal and compile the Java files:
   ```bash
   javac src/*.java
   ```

4. **Run the Application:**
   From the project's root directory, run the compiled code:
   ```bash
   java src.Main
   ```
   This will start the console application, and you can interact with the library management system through the menu options.

## Notes on Code Design and Concepts

- **OOP Concepts:** The project demonstrates key OOP principles through the design of the `Book`, `Borrower`, and `BorrowingProcess` classes. Encapsulation is used to protect data within classes. Inheritance can be extended by creating subclasses of `Book` (e.g., `PaperbackBook`, `Ebook`) to represent different book types with specific attributes or behaviors. Polymorphism can be applied when handling different types of books through a common interface or base class. Interfaces can be used to define common behaviors like `Searchable` for classes that can be searched.
- **Code Structure:** The code is organized into the `src` directory.
- **Error Handling:** Basic error handling is included for invalid inputs or operations (e.g., borrowing an already borrowed book). More robust error handling could be added.
- **Data Persistence:** This version of the system does not include data persistence. Data is stored in memory and will be lost when the application exits.

## Author Information

- **Name:** [Zeghouane Leila]
- **Group:** [Group 02]
