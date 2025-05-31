public class FetchThread extends Thread {
    private final WarehouseManager manager;
    private final int threadId;
    private int amount;
    private boolean hasNewTask = false;

    public FetchThread(WarehouseManager manager, int threadId) {
        this.manager = manager;
        this.threadId = threadId;
    }

    public synchronized void setTask(int amount) {
        this.amount = amount;
        this.hasNewTask = true;
        notify();
    }

    public synchronized void waitForTask() throws InterruptedException {
        while (!hasNewTask) {
            wait();
        }
        hasNewTask = false;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                waitForTask();
                manager.fetch(amount, threadId);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
