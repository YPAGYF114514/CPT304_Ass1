import java.io.*;
import java.util.*;

public class Database {
    private static Database instance;
    private List<Book> books; // 用于存储书籍数据
    private List<User> users; // 用于存储用户数据

    private Database() {
        books = new ArrayList<>();
        // 加载书籍数据
        loadBooks();
    }

    public static synchronized Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooks();
    }

    public void removeBook(Book book) {
        books.remove(book);
        saveBooks();
    }

    // 加载书籍数据
    private void loadBooks() {
        try (BufferedReader br = new BufferedReader(new FileReader("books.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                books.add(new Book(values[0],values[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 保存书籍数据
    private void saveBooks() {
        try (PrintWriter pw = new PrintWriter(new FileOutputStream("books.csv"))) {
            for (Book book : books) {
                pw.println(book.toCSVFormat());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

