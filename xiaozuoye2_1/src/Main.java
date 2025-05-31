public class Main {
    private static  int watchdog = 0;
    private static Thread threadA;
    private static  boolean simulateError = false;  // 控制是否模拟线程A出错

    public static void main(String[] args) throws InterruptedException {
        startA();

        // 延迟一段时间后模拟线程A出错,只进行一次
        new Thread(() -> {
            try {
                Thread.sleep(10000);  // 10秒后模拟A出错
                System.out.println("开始模拟线程A出错...");
                simulateError = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        startB();
    }

    public static void startA() {
        threadA = new Thread(() -> {
            try {
                while (true) {
                    System.out.println("A正在工作...");

                    if (simulateError) {
                        System.out.println("A: 模拟线程出错，不再更新watchdog");
                        Thread.sleep(30000);  // 长时间等待，模拟线程卡住
                    } else {
                        Thread.sleep(3000); // 正常情况下每3秒更新watchdog
                        watchdog = 1;
                        System.out.println("A: watchdog 更新为 1");
                    }
                }
            } catch (InterruptedException e) {
                System.out.println("A被中断，退出线程");
            }
        });
        threadA.setName("thread-A");
        threadA.start();
    }

    public static void startB() {
        Thread threadB = new Thread(() -> {
            int zeroCount = 0;
            while (true) {
                try {
                    Thread.sleep(1000); // 每1秒检查一次
                    if (watchdog == 1) {
                        watchdog = 0;
                        zeroCount = 0;
                        System.out.println("B: A 正常，watchdog 重置为 0");
                    } else {
                        zeroCount++;
                        System.out.println("B: A 未响应，zeroCount = " + zeroCount);
                        if (zeroCount >= 10) {
                            System.out.println("B: 报警：线程A可能出错！");

                            // 尝试重新启动 A
                            if (threadA != null && threadA.isAlive()) {
                                threadA.interrupt(); // 尝试中断旧线程
                            }
                            simulateError = false;  // 重置错误标志
                            System.out.println("B: 尝试重新启动线程 A...");
                            startA();
                            zeroCount = 0;
                        }
                    }
                } catch (InterruptedException e) {
                    System.out.println("B: 被中断，退出线程");
                }
            }
        });
        threadB.setName("Thread-B");
        threadB.start();
    }
}