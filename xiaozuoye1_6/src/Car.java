// 汽车类
class Car implements Display {
    private int oil;

    public Car(int oil) {
        this.oil = oil;
    }

    @Override
    public void display() {
        System.out.println("汽车油量：" + oil);
    }
}