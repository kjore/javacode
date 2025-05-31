//第一问：
//
//要求在子类的 equals 方法中，除了比较子类自身的属性（如 c），还需要确保父类的对象也相等（即调用 super.equals(obj)）。
//这种实现遵循严格的面向对象原则，不允许不同子类之间互相比较，即只有同类对象且父类和子类的属性都相等时才认为相等。
//第二问：
//
//修改后的 equals 方法允许不同子类对象之间进行比较，只要它们的父类属性 p 和子类属性 c 相等，就认为它们相等。
//这种实现放宽了比较规则，允许跨类比较，但违反了面向对象编程的设计原则（如 Liskov 替换原则和对称性）。
public class Main {
    public static void main(String[] args) {
        // 创建父类对象
        P p1 = new P(10);
        P p2 = new P(10);
        P p3 = new P(20);

        // 创建子类对象
        C1 c1_1 = new C1(10, 100);
        C1 c1_2 = new C1(10, 100);
        C1 c1_3 = new C1(10, 200);
        C1 c1_4 = new C1(20, 100);

        C2 c2_1 = new C2(10, 100);
        C2 c2_2 = new C2(10, 100);
        C2 c2_3 = new C2(10, 200);

        // 测试父类对象之间的相等性
        System.out.println("--- 测试父类对象之间的相等性 ---");
        System.out.println("p1.equals(p1): " + p1.equals(p1)); // 应为true（自反性）
        System.out.println("p1.equals(p2): " + p1.equals(p2)); // 应为true（相同p值）
        System.out.println("p1.equals(p3): " + p1.equals(p3)); // 应为false（不同p值）

        // 测试子类对象之间的相等性
        System.out.println("\n--- 测试子类对象之间的相等性 ---");
        System.out.println("c1_1.equals(c1_1): " + c1_1.equals(c1_1)); // 应为true（自反性）
        System.out.println("c1_1.equals(c1_2): " + c1_1.equals(c1_2)); // 应为true（相同p和c值）
        System.out.println("c1_1.equals(c1_3): " + c1_1.equals(c1_3)); // 应为false（不同c值）
        System.out.println("c1_1.equals(c1_4): " + c1_1.equals(c1_4)); // 应为false（不同p值）

        System.out.println("c2_1.equals(c2_1): " + c2_1.equals(c2_1)); // 应为true（自反性）
        System.out.println("c2_1.equals(c2_2): " + c2_1.equals(c2_2)); // 应为true（相同p和c值）
        System.out.println("c2_1.equals(c2_3): " + c2_1.equals(c2_3)); // 应为false（不同c值）

        // 测试不同类对象之间的相等性
        System.out.println("\n--- 测试不同类对象之间的相等性 ---");
        System.out.println("p1.equals(c1_1): " + p1.equals(c1_1)); // 应为false（不同类）
        System.out.println("c1_1.equals(p1): " + c1_1.equals(p1)); // 应为false（不同类）
        System.out.println("c1_1.equals(c2_1): " + c1_1.equals(c2_1)); // 应为false（不同类）

        // 取消C1类中注释的equals方法并注释掉原方法后，以下测试结果将会改变
        System.out.println("\n--- 如果使用修改后的equals方法（允许跨类比较）---");
        System.out.println("在C1和C2类中启用注释掉的equals方法后，c1_1.equals(c2_1)可能为true");

        // 测试null和不同类型
        System.out.println("\n--- 测试null和不同类型 ---");
        System.out.println("p1.equals(null): " + p1.equals(null)); // 应为false
        System.out.println("c1_1.equals(\"测试\"): " + c1_1.equals("测试")); // 应为false
    }
}