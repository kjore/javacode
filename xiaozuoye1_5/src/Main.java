
// 测试接口属性和方法的默认修饰符 JDK 1.8
interface Test {
    int A = 10;
    void method();
}

public class Main {
    public static void main(String[] args) {
        // 测试接口属性A的默认修饰符
        // 如果A是static，可以通过接口名直接访问
        System.out.println("通过接口名访问: " + Test.A);

        // 尝试修改A的值（如果编译失败，证明是final）
        // Test.A = 20;

        // 方法测试
        // 创建一个类实现该接口，看访问修饰符要求
        Test t = new Test() {
            // 如果不用public实现方法，编译器会报错
            @Override
             public void method() { // 必须是public，其他修饰符会导致编译错误
                System.out.println("接口方法实现");
            }
        };


    }
}