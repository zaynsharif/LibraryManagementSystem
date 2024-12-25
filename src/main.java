import cogs.Library;
import scripts.Book;
import scripts.User;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        // Adding books to the library
        library.addBook(new Book("The Alchemist", "Paulo Coelho"));
        library.addBook(new Book("1984", "George Orwell"));

        // Creating users
        User user1 = new User("Mustafa");
        User user2 = new User("Zayn");

        // Listing available books
        library.listBooks();

        // Borrowing books
        library.borrowBook(user1, "The Alchemist");
        library.borrowBook(user2, "1984");

        // Trying to borrow a book that is already borrowed
        library.borrowBook(user2, "The Alchemist");

        // Listing books after borrowing
        library.listBooks();

        // Returning a book
        library.returnBook(user1);

        // Listing books after returning
        library.listBooks();
    }
}
