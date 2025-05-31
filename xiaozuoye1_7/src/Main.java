// 定义一个接口
interface Test {
    void test();
}

// 实现该接口的类
class T implements Test {
    @Override
    public void test() {
        System.out.println("测试中");
    }

    // 接口中未定义的方法
    public void testfunc() {
        System.out.println("接口中未定义的方法");
    }
}

public class Main {
    public static void main(String[] args) {
        // 通过接口引用实现类对象
        Test test = new T();

        // 可以调用接口中定义的方法
        test.test();

        // 无法调用未在接口中定义的方法
        //test.testfunc();
        // 需要将接口引用转换为实现类类型
        ((T) test).testfunc(); // 强制类型转换调用未定义的方法
    }
}