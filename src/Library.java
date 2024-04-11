//import java.util.*;
//
public class Library {
//    private List<Observer> observers = new ArrayList<>();
//    private Map<String, Book> books = new HashMap<>();
//    private Map<String, User> users = new HashMap<>();
//   // private BookFactory bookFactory = new BookFactory();
//
//
//    @Override
//    public void registerObserver(Observer observer) {
//        observers.add(observer);
//    }
//
//    @Override
//    public void removeObserver(Observer observer) {
//        observers.remove(observer);
//    }
//
//    @Override
//    public void notifyObservers(String message) {
//        for (Observer observer : observers) {
//            observer.update(message);
//        }
//    }
//
//    public void registerUser(User user) {
//        users.put(user.getName(), user);
//        registerObserver(user);
//    }
//    public List<User> getAllUsers() {
//        // Return a new list containing all users
//        return new ArrayList<>(users.values());
//    }
//    public Book addBook(String title, String type) {
//        Book book = bookFactory.createBook(type, title);
//        books.put(title, book);
//        return book;
//    }
//
//    public void removeBook(String title) {
//        books.remove(title);
//    }
//
//    public void checkOutBook(String title, String userName) {
//        Book book = books.get(title);
//        User user = users.get(userName);
//
//        if (book != null && user != null) {
//            System.out.println(user.getName() + " checked out book: " + book.getTitle());
//            notifyObservers("Book checked out: " + book.getTitle() + " by " + user.getName());
//            // Additional functionality for checking out books
//        } else {
//            System.out.println("Book or user not found.");
//        }
//    }
//
//    public void checkInBook(String title) {
//        Book book = books.get(title);
//        if (book != null) {
//            System.out.println("Book checked in: " + book.getTitle());
//            notifyObservers("Book checked in: " + book.getTitle());
//            // Additional functionality for checking in books
//        } else {
//            System.out.println("Book not found.");
//        }
//    }
//    public List<Book> getAllBooks() {
//        // Return a new list containing all books in the library
//        return new ArrayList<>(books.values());
//    }
}
