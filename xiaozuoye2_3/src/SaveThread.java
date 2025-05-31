public class SaveThread extends Thread {
    private final WarehouseManager manager;
    private int amount;
    private boolean hasNewTask = false;

    public SaveThread(WarehouseManager manager) {
        this.manager = manager;
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
                manager.save(amount, 3);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
