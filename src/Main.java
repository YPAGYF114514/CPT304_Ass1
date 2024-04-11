import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String ADMIN_PASSWORD = "123";  // Set your administrator password here

    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Ask the user whether they are a user or administrator
        System.out.println("Welcome to the Library Management System");
        System.out.println("Are you a administrator?");
        System.out.print("Enter your answer[y/n]: ");
        String role = scanner.nextLine().toLowerCase();

        if (role.equals("y")) {
            // Prompt for administrator password
            System.out.print("Enter administrator password: ");
            String password = scanner.nextLine();

            // Check password
            if (!password.equals(ADMIN_PASSWORD)) {
                System.out.println("Incorrect password. Access denied.");
                return;
            }

            // Administrator access granted
            System.out.println("Administrator access granted.");
            runAdminInterface(library, scanner);
        } else if (role.equals("n")) {
            // User access granted
            System.out.println("User access granted.");
            runUserInterface(library, scanner);
        } else {
            // Invalid input
            System.out.println("Invalid input. Exiting...");
        }

        scanner.close();
    }

    // Method to handle administrator interface
    private static void runAdminInterface(Library library, Scanner scanner) {
        while (true) {
            System.out.println("\nAdministrator Menu");
            System.out.println("1. Register User");
            System.out.println("2. Add Book");
            System.out.println("3. Remove Book");
            System.out.println("4. All Users");
            System.out.println("5. ALl Books");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
//                    System.out.print("Enter user name: ");
//                    String userName = scanner.nextLine();
//                    User user = new User(userName);
//                    library.registerUser(user);
//                    System.out.println("User registered.");
//                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter book type (1.Novel/2.Textbook): ");
                    String bookType = scanner.nextLine();
                    if (bookType.equals("1")) {
                        Book book = library.addBook(bookTitle, "Novel");
                        System.out.println("Book added: " + book.getTitle());
                    }
                    if (bookType.equals("2")) {
                        Book book = library.addBook(bookTitle, "Textbook");
                        System.out.println("Book added: " + book.getTitle());
                    }
                    else System.out.println("Wrong type! Try again.");
                    break;
                case 3:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    library.removeBook(removeTitle);
                    System.out.println("Book removed.");
                    break;
                case 4:
                    List<User> allUsers = library.getAllUsers();
                    System.out.println("\nList of All Users:");
                    for (User user1 : allUsers) {
                        System.out.println("Name: " + user1.getName());
                    }
                    break;
                case 5:
                    // Handle the option to view all books
                    List<Book> allBooks = library.getAllBooks();
                    System.out.println("\nList of All Books:");
                    for (Book book : allBooks) {
                     //   System.out.println("Title: " + book.getTitle() + ", Type: " + book.getType());
                    }
                    break;

                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Method to handle user interface
    private static void runUserInterface(Library library, Scanner scanner) {
        while (true) {
            System.out.println("\nUser Menu");
            System.out.println("1. Check Out Book");
            System.out.println("2. Check In Book");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title to check out: ");
                    String checkoutTitle = scanner.nextLine();
                    System.out.print("Enter user name: ");
                    String checkoutUserName = scanner.nextLine();
                    library.checkOutBook(checkoutTitle, checkoutUserName);
                    break;
                case 2:
                    System.out.println("Enter book title to check in: ");
                    String checkinTitle = scanner.nextLine();
                    library.checkInBook(checkinTitle);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
