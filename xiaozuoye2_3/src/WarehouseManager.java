import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class WarehouseManager {
    private final Warehouse[] warehouses;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition saveCondition = lock.newCondition();
    private final Condition fetchCondition = lock.newCondition();

    public WarehouseManager(Warehouse[] warehouses) {
        this.warehouses = warehouses;
    }

    public void save(int amount, int threadId) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                // 找到货物最少的仓库
                Warehouse minWarehouse = findMinStockWarehouse();

                if (minWarehouse.canSave(amount)) {
                    minWarehouse.save(amount);
                    System.out.println("Save线程存入 " + amount + " 个货物到仓库" + minWarehouse.getId());
                    printWarehouseStatus();
                    // 通知可能在等待的fetch线程
                    fetchCondition.signalAll();
                    break;
                } else {
                    System.out.println("Save线程等待：仓库" + minWarehouse.getId() + "空间不足");
                    saveCondition.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void fetch(int amount, int threadId) throws InterruptedException {
        lock.lock();
        try {
            while (true) {
                // 找到货物最多的仓库
                Warehouse maxWarehouse = findMaxStockWarehouse();

                if (maxWarehouse.canFetch(amount)) {
                    maxWarehouse.fetch(amount);
                    System.out.println("Fetch" + threadId + "线程取出 " + amount + " 个货物从仓库" + maxWarehouse.getId());
                    printWarehouseStatus();
                    // 通知可能在等待的save线程
                    saveCondition.signalAll();
                    break;
                } else {
                    System.out.println("Fetch" + threadId + "线程等待：仓库" + maxWarehouse.getId() + "货物不足");
                    fetchCondition.await();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private Warehouse findMinStockWarehouse() {
        Warehouse minWarehouse = warehouses[0];
        for (int i = 1; i < warehouses.length; i++) {
            if (warehouses[i].getStock() < minWarehouse.getStock()) {
                minWarehouse = warehouses[i];
            }
        }
        return minWarehouse;
    }

    private Warehouse findMaxStockWarehouse() {
        Warehouse maxWarehouse = warehouses[0];
        for (int i = 1; i < warehouses.length; i++) {
            if (warehouses[i].getStock() > maxWarehouse.getStock()) {
                maxWarehouse = warehouses[i];
            }
        }
        return maxWarehouse;
    }

    private void printWarehouseStatus() {
        System.out.println("当前仓库状态：" + Arrays.toString(warehouses));
    }
}
