package cogs;

import scripts.Book;
import scripts.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();
    private HashMap<User, Book> borrowedBooks = new HashMap<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println(book.getTitle() + " added to the library.");
    }

    public void borrowBook(User user, String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(bookTitle) && !book.isBorrowed()) {
                book.borrow();
                borrowedBooks.put(user, book);
                System.out.println(user.getName() + " borrowed " + book.getTitle());
                return;
            }
        }
        System.out.println("Book not available or already borrowed.");
    }

    public void returnBook(User user) {
        if (borrowedBooks.containsKey(user)) {
            Book book = borrowedBooks.remove(user);
            book.returnBook();
            System.out.println(user.getName() + " returned " + book.getTitle());
        } else {
            System.out.println("No book borrowed by " + user.getName());
        }
    }

    public void listBooks() {
        System.out.println("Books in the library:");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
