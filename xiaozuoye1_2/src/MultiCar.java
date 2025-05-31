// 多功能汽车（既载人又载货）
public class MultiCar extends Car {
    private int passengerCapacity; // 载人数量
    private int truckcapcity; // 载货量（吨）

    public MultiCar(int id, String name, int cost, int passengerCapacity, int truckcapacity) {
        super(id, name, cost);
        this.passengerCapacity = passengerCapacity;
        this.truckcapcity = truckcapacity;
    }

    @Override
    public String getInfo() {
        return String.format("序号：%d  汽车名称:%s 租金%d/天 容量：最多载人%d人，最多载货%d吨",
                getId(), getName(), getDaycost(), passengerCapacity, truckcapcity);
    }
}