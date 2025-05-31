import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CarList carList = new CarList();
        List<RentalOrder> orders = new ArrayList<>();

        System.out.println("欢迎使用租车系统");
        System.out.println("你是否要租车:1是 0否");
        int choice = scanner.nextInt();

        if (choice == 1) {
            // 显示可用车辆
            carList.display();

            // 输入租车数量
            System.out.println("请输入您要租汽车的数量：");
            int count = scanner.nextInt();

            System.out.println("请输入您要租车的序号和天数");
            for (int i = 0; i < count; i++) {
                int carId = scanner.nextInt();
                int days = scanner.nextInt();

                Car selectedCar = carList.getCar(carId);
                if (selectedCar != null) {
                    orders.add(new RentalOrder(selectedCar, days));
                }
            }

            // 显示账单
            System.out.println("您的账单：");
            int cost = 0;
            for (RentalOrder order : orders) {
                System.out.println(order.getCar().getName() + "   " + order.getDays() + "天");
                cost += order.calculateTotal();
            }
            System.out.println("总价格：" + cost + "元");
        }

        scanner.close();
    }
}