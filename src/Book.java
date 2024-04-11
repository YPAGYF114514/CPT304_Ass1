import java.time.LocalDate;

// 修改 Book 类，让它实现 FineCalculator 接口
public class Book implements FineCalculator {
    private String title;
    private LocalDate borrowDate; // 借出日期
    private LocalDate dueDate; // 应还日期
    private boolean isOverdue; // 是否超期
    private User currentUser; // 当前借阅用户
    private FineCalculator fineCalculator; // 超期罚款计算器
    private String author;
    public Book(String title) {
        this.title = title;
        this.author =author;
        this.isOverdue = false; // 默认未超期
        this.fineCalculator = new OverdueFineCalculator(this);
    }

    // Getter 和 Setter 方法
    public String getTitle() {
        return title;
    }

    public String getAuthor(){return author;}

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

    /**
     * 装饰者模式在其中是怎么应用的
     * 接口 FineCalculator：
     * 我们定义了一个接口 FineCalculator，其中包含了一个 calculateFine 方法，用于计算超期罚款金额。
     * 具体的装饰者类 OverdueFineCalculator：
     * 这个类实现了 FineCalculator 接口，并包含一个 Book 对象的引用。
     * 在 calculateFine 方法中，它通过 Book 对象来获取借书信息，并根据超期天数计算罚款金额。
     * Book 类的修改：
     * 我们修改了 Book 类，让其实现了 FineCalculator 接口。
     * 在构造方法中，我们创建了一个 OverdueFineCalculator 对象，并将当前 Book 对象传递给它，这样 OverdueFineCalculator 就能够访问 Book 对象的信息。
     * 我们修改了原先 Book 类中的 calculateFine 方法，使其调用装饰者对象的 calculateFine 方法。
     * 应用：
     * 当我们需要计算超期罚款时，不再直接调用 Book 对象的方法，而是调用其实现的 FineCalculator 接口方法。
     * 这样，我们可以轻松地改变超期罚款的计算方式，而无需修改 Book 类的代码。例如，如果以后需要更改罚款金额或者罚款方式，只需要修改 OverdueFineCalculator 类的实现即可，而不会影响到 Book 类的其他部分。
     * 这种方式符合装饰者模式的思想：通过将责任分离，可以动态地为对象添加新的行为，同时避免了类继承的静态方式。
     * @param returnDate
     * @return
     */
    @Override
    public double calculateFine(LocalDate returnDate) {
        return fineCalculator.calculateFine(returnDate);
    }

    public String toCSVFormat() {
        return title + ","  + author + ","+(currentUser != null ? currentUser.getName() : "None") + "," + borrowDate + "," + dueDate + "," + isOverdue;
    }
}
