import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 创建三个仓库
        Warehouse[] warehouses = new Warehouse[3];
        for (int i = 0; i < 3; i++) {
            warehouses[i] = new Warehouse(i+1, 20);
        }

        // 创建仓库管理器
        WarehouseManager manager = new WarehouseManager(warehouses);

        // 创建并启动线程
        FetchThread fetch1 = new FetchThread(manager, 1);
        FetchThread fetch2 = new FetchThread(manager, 2);
        SaveThread save = new SaveThread(manager);

        fetch1.start();
        fetch2.start();
        save.start();

        // 处理用户输入
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入操作: ");

        while (true) {
            String input = scanner.nextLine().trim();
            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            try {
                String[] parts = input.split("\\s+");
                int threadId = Integer.parseInt(parts[0]);
                int amount = Integer.parseInt(parts[1]);

                if (amount < 1 || amount > 5) {
                    System.out.println("数量必须在1-5之间");
                    continue;
                }

                switch (threadId) {
                    case 1:
                        fetch1.setTask(amount);
                        break;
                    case 2:
                        fetch2.setTask(amount);
                        break;
                    case 3:
                        save.setTask(amount);
                        break;
                    default:
                        System.out.println("线程ID必须是1、2或3");
                }
            } catch (Exception e) {
                System.out.println("输入格式错误，请重新输入");
            }
        }

        // 关闭线程和资源
        fetch1.interrupt();
        fetch2.interrupt();
        save.interrupt();
        scanner.close();
        System.out.println("程序已退出");
    }
}
