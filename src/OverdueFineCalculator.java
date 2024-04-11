import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @ClassName OverdueFineCalculator
 * @Desc
 * @Author wangjian
 * @Date 2024/4/11 15:02
 * @Version 1.0
 **/ // 具体的装饰者类
public class OverdueFineCalculator implements FineCalculator {
    private Book book;

    public OverdueFineCalculator(Book book) {
        this.book = book;
    }

    @Override
    public double calculateFine(LocalDate returnDate) {
        if (!book.isOverdue()) {
            return 0.0; // 如果没有超期，罚款为0
        }
        long overdueDays = ChronoUnit.DAYS.between(book.getDueDate(), returnDate);
        return overdueDays * 0.5; // 假设每天的罚金是0.5元
    }
}
