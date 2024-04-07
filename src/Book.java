import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Book {
    private String title;
    private LocalDate borrowDate; // 借出日期
    private LocalDate dueDate; // 应还日期
    private boolean isOverdue; // 是否超期
    private User currentUser; // 当前借阅用户

    public Book(String title) {
        this.title = title;
        this.isOverdue = false; // 默认未超期
    }

    // Getter 和 Setter 方法
    public String getTitle() {
        return title;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isOverdue() {
        return isOverdue;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void checkOverdue(LocalDate returnDate) {
        if (returnDate.isAfter(dueDate)) {
            isOverdue = true;
        } else {
            isOverdue = false;
        }
    }

    // 超期罚款计算方法
    public double calculateFine(LocalDate returnDate) {
        if (!isOverdue) {
            return 0.0; // 如果没有超期，罚款为0
        }
        long overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        return overdueDays * 0.5; // 假设每天的罚金是0.5元
    }

    public String toCSVFormat() {
        return title + "," + (currentUser != null ? currentUser.getName() : "None") + "," + borrowDate + "," + dueDate + "," + isOverdue;
    }
}
