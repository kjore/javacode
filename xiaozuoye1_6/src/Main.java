
public class Main {
    public static void main(String[] args) {
        // 创建一个接口数组，包含5个对象
        Display[] displays = new Display[5];

        // 创建5个对象并存入数组
        displays[0] = new Inform("系统更新");
        displays[1] = new Car(80);
        displays[2] = new Ad("限时促销");
        displays[3] = new Inform("会议提醒");
        displays[4] = new Ad("新产品发布");

        // 通过接口引用执行display()方法
        for (Display item : displays) {
            item.display();
        }
    }
}