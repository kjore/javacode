// 载人汽车
public class PassengerCar extends Car {
    private int passengerCapacity; // 载人数量

    public PassengerCar(int id, String name, int cost, int passengerCapacity) {
        super(id, name, cost);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String getInfo() {
        return String.format("序号：%d  汽车名称:%s 租金%d/天 容量：最多载人%d人",
                getId(), getName(), getDaycost(), passengerCapacity);
    }
}