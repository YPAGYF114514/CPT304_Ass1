import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Database db = Database.getInstance();

        // 添加书籍
        db.addBook(new Book("The Great Gatsby"));
        db.addBook(new Book("Mock"));

        System.out.println("Hello world!");
        System.out.println("Hello world!");
        System.out.println("Hello world!");
        System.out.println("Hello world!");
        System.out.println("Hello world!");
    }
}