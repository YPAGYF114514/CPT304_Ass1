import java.time.LocalDate;

/**
 * @ClassName FineCalculator
 * @Desc
 * @Author wangjian
 * @Date 2024/4/11 15:02
 * @Version 1.0
 **/ // 定义超期罚款计算行为的接口
public interface FineCalculator {
    double calculateFine(LocalDate returnDate);
}
