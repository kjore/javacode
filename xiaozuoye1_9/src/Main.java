//main方法用try-catch包裹，捕获了所有Throwable（包括Exception和Error），主线程的异常不会抛出到JVM
//通过Thread.setDefaultUncaughtExceptionHandler设置了全局未捕获异常处理器，能捕获所有子线程未捕获的异常，防止它们抛出到JVM

public class Main {
    public static void main(String[] args) {
        try {
            // 设置未捕获异常处理器
            Thread.setDefaultUncaughtExceptionHandler((thread, throwable) -> {
                System.err.println("捕获到线程 " + thread.getName() + " 中的异常: " + throwable.getMessage());
            });

            // 程序主逻辑
            runexception();

        } catch (Throwable t) {
            // 捕获主线程中的所有异常和错误
            System.err.println("主线程捕获到异常: " + t.getMessage());
        }
    }

    private static void runexception() {
        // 示例：可能抛出异常的代码
        int result = 10 / 0; // 故意引发算术异常
    }
}