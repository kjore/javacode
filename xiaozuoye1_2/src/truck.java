// 载货汽车
public class truck extends Car {
    private int truckcapacity; // 载货量（吨）

    public truck(int id, String name, int cost, int truckcapacity) {
        super(id, name, cost);
        this.truckcapacity = truckcapacity;
    }

    @Override
    public String getInfo() {
        return String.format("序号：%d  汽车名称:%s 租金%d/天 容量：最多载货%d吨",
                getId(), getName(), getDaycost(), truckcapacity);
    }
}