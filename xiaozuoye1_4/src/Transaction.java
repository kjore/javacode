import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private LocalDateTime timestamp;
    private String type;
    private double amount;
    private double balanceAfter;

    public Transaction(String type, double amount, double balanceAfter) {
        this.timestamp = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
        this.balanceAfter = balanceAfter;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String amountStr = amount >= 0 ? "+" + amount : String.valueOf(amount);
        return String.format("%s | %-10s | %10s | 余额: %.2f",
                timestamp.format(formatter), type, amountStr, balanceAfter);
    }
}