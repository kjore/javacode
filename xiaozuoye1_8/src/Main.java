public class Main {
    public static void main(String[] args) {
        try {
            // 尝试检查年龄
            checkAge(200);
            System.out.println("年龄检查通过");
        } catch (MyException e) {
            // 捕获并处理自定义异常
            System.out.println("捕获到异常: " + e.getMessage());
            // 打印异常堆栈信息
            e.printStackTrace();
        }
    }

    // 可能抛出自定义异常的方法
    public static void checkAge(int age) throws MyException {
        if (age < 0) {
            throw new MyException("年龄不能为负数: " + age);
        } else if (age > 150) {
            throw new MyException("年龄超出正常范围: " + age);
        }
        // 年龄合法，方法正常结束
    }
}