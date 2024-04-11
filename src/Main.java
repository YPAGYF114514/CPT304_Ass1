import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Database db = Database.getInstance();

        // 添加书籍
        db.addBook(new Book("The Great Gatsby","author1"));
        db.addBook(new Book("Mock","author2"));

        User u = new User("1", "a", "123");

        String keyword = "";
        String choice;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //choose search type
        while (true) {
            System.out.println("\nEnter either '1' or '2' for search by Title or Author of Book respectively: ");
            choice = scanner.next();

            if (choice.equals("1") || choice.equals("2"))
                break;
            else
                System.out.println("\nWrong Input!");
        }

        //search book according to the choice
        if (choice.equals("1")) {
            System.out.println("\nEnter the Title of the Book: ");
            try {
                keyword = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            u.setSearchStrategy(new TitleSearch());
            u.searchBook(keyword);
        } else {
            System.out.println("\nEnter the Author of the Book: ");
            try {
                keyword = reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            u.setSearchStrategy(new AuthorSearch());
            u.searchBook(keyword);
        }
        
    }
}
