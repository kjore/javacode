public class Main {
    private static int sum = 0;

    private static void add(int value) {
        sum+=value;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < 10; i++) {
             int num =i;
            threads[i] = new Thread(() -> {
                int start = num*10+1;
                int end = (num+1)*10;

                System.out.println("线程 " + (num+1)+" 开始添加 "+start+" 到 " +end+ " 的数");

                for (int j = start; j <= end; j++) {
                    add(1); // 每次只加1
                }
                System.out.println("线程 " + (num+1) +" 完成添加，当前sum = " + sum);
            });
            threads[i].start();
            try {
                Thread.sleep(1000); // 每个线程启动后等待1秒，确保线程按顺序执行
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 等待所有线程完成
        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("所有线程计算完成，最终 sum = " +sum);
    }
}