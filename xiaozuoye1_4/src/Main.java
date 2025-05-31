public class Main {
    public static void main(String[] args) {
        // 测试开户功能
        System.out.println("\n===== 测试开户功能 =====");
        BankAccount account1 = BankAccount.openAccount("123456", "张三", "110101199001011234", 1000, 2000);
        BankAccount account2 = BankAccount.openAccount("654321", "李四", "110101199102022345", 500, 1000);
        System.out.println("账户1信息：账号=" + account1.getAccountNumber() + ", 持有人=" + account1.getAccountHolder() +
                ", 余额=" + account1.getBalance() + ", 转账限额=" + account1.getTransferLimit());
        System.out.println("账户2信息：账号=" + account2.getAccountNumber() + ", 持有人=" + account2.getAccountHolder() +
                ", 余额=" + account2.getBalance() + ", 转账限额=" + account2.getTransferLimit());

        // 测试存款功能
        System.out.println("\n===== 测试存款功能 =====");
        System.out.println("正常存款:");
        account1.deposit(500);

        System.out.println("负数存款测试:");
        account1.deposit(-100);

        System.out.println("零金额存款测试:");
        account1.deposit(0);

        // 测试取款功能
        System.out.println("\n===== 测试取款功能 =====");
        System.out.println("正常取款:");
        account1.withdraw(200);

        System.out.println("余额不足取款测试:");
        account1.withdraw(10000);

        System.out.println("负数取款测试:");
        account1.withdraw(-50);

        // 测试转账功能
        System.out.println("\n===== 测试转账功能 =====");
        System.out.println("正常转账:");
        account1.transfer(account2, 300);

        System.out.println("转账金额超出限额测试:");
        account1.transfer(account2, 5000);

        System.out.println("设置新的转账限额:");
        account1.setTransferLimit(3000);
        System.out.println("更新后的转账限额: " + account1.getTransferLimit());

        System.out.println("负数转账金额测试:");
        account1.transfer(account2, -200);

        System.out.println("余额不足转账测试:");
        account1.transfer(account2, 2000);

        // 测试查询余额
        System.out.println("\n===== 测试查询余额 =====");
        System.out.println("张三当前余额: " + account1.checkBalance());
        System.out.println("李四当前余额: " + account2.checkBalance());

        // 测试打印交易明细
        System.out.println("\n===== 测试打印交易明细 =====");
        account1.printTransactionHistory();
        account2.printTransactionHistory();

        // 测试销户功能
        System.out.println("\n===== 测试销户功能 =====");
        System.out.println("账户1销户:");
        double refundedAmount = account1.closeAccount();
        System.out.println("退还金额: " + refundedAmount);

        // 测试销户后的操作限制
        System.out.println("\n===== 测试销户后的操作限制 =====");
        System.out.println("尝试对已销户账户存款:");
        account1.deposit(100);

        System.out.println("尝试对已销户账户取款:");
        account1.withdraw(100);

        System.out.println("尝试从已销户账户转账:");
        account1.transfer(account2, 100);

        System.out.println("尝试查询已销户账户余额:");
        System.out.println("销户后余额: " + account1.checkBalance());

        System.out.println("尝试打印已销户账户交易明细:");
        account1.printTransactionHistory();

        System.out.println("尝试对已销户的账户再次销户:");
        account1.closeAccount();

        System.out.println("\n===== 测试向已销户账户转账 =====");
        account2.transfer(account1, 100);

        // 创建一个新账户测试零初始余额开户
        System.out.println("\n===== 测试零初始余额开户 =====");
        BankAccount account3 = BankAccount.openAccount("789012", "王五", "110101199203033456", 0, 500);
        System.out.println("账户3信息：账号=" + account3.getAccountNumber() + ", 持有人=" + account3.getAccountHolder() +
                ", 余额=" + account3.getBalance() + ", 转账限额=" + account3.getTransferLimit());
    }
}