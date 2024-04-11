import java.time.LocalDate;
import java.time.chrono.ChronoLocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String id; // 用户唯一标识
    private String name; // 用户名
    private String email; // 用户邮箱
    private List<Book> borrowedBooks; // 借阅的书籍列表

    private int accountBalance;
    private BookSearchStrategy searchStrategy;//search type
    
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.borrowedBooks = new ArrayList<>(); // 初始化时没有借阅的书籍
        this.accountBalance = 0;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // 借阅书籍
    public void borrowBook(Book book) {
        borrowedBooks.add(book);
        // 可以在这里添加更多逻辑，比如更新数据库、检查用户借阅限制等
    }

    public void returnBook(Book book, LocalDate returnDate) {
        // 检查书籍是否超期
        book.checkOverdue(returnDate);

        // 如果书籍超期，计算罚款
        if (book.isOverdue()) {
            double fine = book.calculateFine(returnDate);
            // 处理罚款逻辑，比如更新用户余额、记录罚款历史等
            // 这里假设有一个方法叫 applyFine() 来处理罚款
            applyFine(fine);
        }

        // 从用户借阅列表中移除书籍
        borrowedBooks.remove(book);

        // 清除书籍的当前借阅用户信息
        book.setCurrentUser(null);

        // 可以在这里添加更多逻辑，比如更新数据库等
    }
    // 处理罚款的示例方法，实际应用中你需要根据自己的业务逻辑实现
    private void applyFine(double fine) {
        // 更新用户的罚款信息
        // 假设有一个属性叫做 fineAmount 来存储用户的总罚款金额
        this.accountBalance -= fine;
    }
    
    //search book
    public void setSearchStrategy(BookSearchStrategy searchStrategy){
        this.searchStrategy = searchStrategy;
    }
    public void searchBook(String keyword){
        searchStrategy.search(keyword);
    }
}

