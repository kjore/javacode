import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String accountNumber;      // 账户号码
    private String username;      // 储户姓名
    private LocalDateTime openDate;    // 开户时间
    private String idNumber;           // 身份证号码
    private double balance;            // 存款余额
    private double transferLimit;      // 转账额度
    private boolean active;            // 账户状态
    private List<Transaction> transactions; // 交易记录

    // 构造函数
    public BankAccount(String accountNumber, String username, String idNumber, double initialDeposit, double transferLimit) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.idNumber = idNumber;
        this.balance = initialDeposit;
        this.transferLimit = transferLimit;
        this.openDate = LocalDateTime.now();
        this.active = true;
        this.transactions = new ArrayList<>();

        // 记录开户交易
        addTransaction("开户", initialDeposit, balance);
    }

    // 开户方法
    public static BankAccount openAccount(String accountNumber, String accountHolder, String idNumber, double initialDeposit, double transferLimit) {
        return new BankAccount(accountNumber, accountHolder, idNumber, initialDeposit, transferLimit);
    }

    // 存款方法
    public void deposit(double amount) {
        if (!active) {
            System.out.println("账户已销户，不能进行操作");
            return;
        }

        if (amount <= 0) {
            System.out.println("存款金额必须为正数");
            return;
        }

        balance += amount;
        addTransaction("存款", amount, balance);
        System.out.println("存款成功，当前余额: " + balance);
    }

    // 取款方法
    public boolean withdraw(double amount) {
        if (!active) {
            System.out.println("账户已销户，不能进行操作");
            return false;
        }

        if (amount <= 0) {
            System.out.println("取款金额必须为正数");
            return false;
        }

        if (amount > balance) {
            System.out.println("余额不足，取款失败");
            return false;
        }

        balance -= amount;
        addTransaction("取款", -amount, balance);
        System.out.println("取款成功，当前余额: " + balance);
        return true;
    }

    // 转账方法
    public boolean transfer(BankAccount recipient, double amount) {
        if (!active || !recipient.isActive()) {
            System.out.println("账户已销户或目标账户已销户，不能进行操作");
            return false;
        }

        if (amount <= 0) {
            System.out.println("转账金额必须为正数");
            return false;
        }

        if (amount > balance) {
            System.out.println("余额不足，转账失败");
            return false;
        }

        if (amount > transferLimit) {
            System.out.println("超出转账额度，转账失败。当前额度: " + transferLimit);
            return false;
        }

        balance -= amount;
        recipient.balance += amount;

        addTransaction("转出至" + recipient.getAccountNumber(), -amount, balance);
        recipient.addTransaction("转入自" + this.accountNumber, amount, recipient.getBalance());

        System.out.println("转账成功，当前余额: " + balance);
        return true;
    }

    // 查询余额
    public double checkBalance() {
        if (!active) {
            System.out.println("账户已销户，不能进行操作");
            return -1;
        }
        return balance;
    }

    // 查询交易明细
    public void printTransactionHistory() {
        if (!active) {
            System.out.println("账户已销户，不能进行操作");
            return;
        }

        System.out.println("====== 账户交易明细 ======");
        System.out.println("账号: " + accountNumber + ", 账户持有人: " + username);
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
        System.out.println("当前余额: " + balance);
        System.out.println("=========================");
    }

    // 销户方法
    public double closeAccount() {
        if (!active) {
            System.out.println("账户已销户");
            return 0;
        }

        double remainingBalance = balance;
        addTransaction("销户", -balance, 0);
        balance = 0;
        active = false;
        System.out.println("账户已成功销户，退还余额: " + remainingBalance);
        return remainingBalance;
    }

    // 记录交易
    private void addTransaction(String type, double amount, double newBalance) {
        Transaction transaction = new Transaction(type, amount, newBalance);
        transactions.add(transaction);
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolder() {
        return username;
    }

    public LocalDateTime getOpenDate() {
        return openDate;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public double getBalance() {
        return balance;
    }

    public double getTransferLimit() {
        return transferLimit;
    }

    public boolean isActive() {
        return active;
    }

    // 设置转账限额
    public void setTransferLimit(double transferLimit) {
        if (transferLimit > 0) {
            this.transferLimit = transferLimit;
            System.out.println("转账限额已更新为: " + transferLimit);
        } else {
            System.out.println("转账限额必须为正数");
        }
    }
}