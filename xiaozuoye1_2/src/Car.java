// 车辆基类
public abstract class Car {
    private String name; // 汽车名称
    private int daycost; // 日租金
    private int id; // 序号

    public Car(int id, String name, int daycost) {
        this.id = id;
        this.name = name;
        this.daycost = daycost;
    }

    public String getName() {
        return name;
    }

    public int getDaycost() {
        return daycost;
    }

    public int getId() {
        return id;
    }

    // 计算租金
    public int totalcost(int days) {
        return daycost * days;
    }

    // 展示车辆信息的抽象方法
    public abstract String getInfo();
}