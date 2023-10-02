/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/d1c0bc6ba628cce30e06c096426ba5ad_MIT6_092IAP10_assn04.pdf

Assignment 4: 
    The libraries of SmallTownX need a new electronic rental system, and it is up to you to build it. SmallTownX has two
libraries. Each library offers many books to rent. Customers can print the list of available books, borrow, and return
books. 
*/

package Assignment4;

public class Book {
    String title;
    boolean borrowed;
    
    // Creates a new Book
    public Book(String bookTitle) {
        title = bookTitle;
        borrowed = false;
    }
    private void rented() {
        borrowed();
    }
    // Marks the book as rented
    public void borrowed() {
        borrowed = true;
    }
    // Marks the book as not rented
    public void returned() {
        borrowed = false;
    }
    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        return borrowed;
    }
    // Returns the title of the book
    public String getTitle() {
        return title;
    }
    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("The Da Vinci Code");
        System.out.println("Title (should be The Da Vinci Code): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.rented();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
} 
