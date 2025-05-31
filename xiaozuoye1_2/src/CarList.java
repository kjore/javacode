import java.util.ArrayList;
import java.util.List;

public class CarList {
    private List<Car> cars;

    public CarList() {
        cars = new ArrayList<>();
        // 初始化车辆信息
        cars.add(new PassengerCar(1, "奥迪A4", 500, 4));
        cars.add(new PassengerCar(2, "马自达6", 400, 4));
        cars.add(new MultiCar(3, "皮卡雪6", 450, 4, 2));
        cars.add(new PassengerCar(4, "金龙", 800, 20));
        cars.add(new truck(5, "松花江", 400, 4));
        cars.add(new truck(6, "依维柯", 1000, 20));
    }

    public Car getCar(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    public void display() {
        System.out.println("您可租车的类型及其价目表");
        for (Car car : cars) {
            System.out.println(car.getInfo());
        }
    }
}