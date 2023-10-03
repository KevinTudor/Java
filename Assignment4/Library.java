/* 
link: https://ocw.mit.edu/courses/6-092-introduction-to-programming-in-java-january-iap-2010/d1c0bc6ba628cce30e06c096426ba5ad_MIT6_092IAP10_assn04.pdf

Assignment 4: 
    The libraries of SmallTownX need a new electronic rental system, and it is up to you to build it. SmallTownX has two
libraries. Each library offers many books to rent. Customers can print the list of available books, borrow, and return
books. 


*/

package Assignment4;

import java.util.*;

public class Library {
    String libraryAddress;
	ArrayList<Book> libraryBooks;

    public Library(String address) {
        libraryAddress = address;
        libraryBooks = new ArrayList<Book>();
    }
    private void addBook(Book book) {
        libraryBooks.add(book);
    }
    private void returnBook(String title) {
        for(int i=0; i<libraryBooks.size(); i++){
            if (libraryBooks.get(i).getTitle() == title && libraryBooks.get(i).isBorrowed()){
                libraryBooks.get(i).returned();
                System.out.println("You successfully returned The Lord of the Rings");
            }
        }
    }
    private void printAvailableBooks() {
        if(libraryBooks.size()>0){
            for(int i=0; i<libraryBooks.size(); i++){
                if (!libraryBooks.get(i).isBorrowed()){
                    System.out.println(libraryBooks.get(i).getTitle());
                }
            }
        }else{
            System.out.println("No book in catalog");
        }
    }
    private String borrowBook(String title) {
        Book tempBook;
        
        for(int i=0; i<libraryBooks.size(); i++){
            tempBook = libraryBooks.get(i);
            if(tempBook.getTitle() == title){
                if(tempBook.isBorrowed()){
                    System.out.println("Sorry, this book is already borrowed.");
                    return title;
                }else{
                    System.out.println("You successfully borrowed "+title);
                    libraryBooks.get(i).borrowed();
                    return title;
                }
            }
        }

        System.out.println("Sorry, this book is not in our catalog.");
        return title;
    }
    private void printAddress() {
        System.out.println(libraryAddress);
    }
    private static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }

    public static void main(String[] args) {
        // Create two libraries
        Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");
        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));
        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();
        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();
        
        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();
        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        System.out.println();
        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
}
