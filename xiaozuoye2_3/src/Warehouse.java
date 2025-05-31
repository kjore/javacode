import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Warehouse {
    private int stock;
    private final int capacity;
    private final int id;

    public Warehouse(int id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        this.stock = 0;
    }

    public int getStock() {
        return stock;
    }

    public int getId() {
        return id;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean canSave(int amount) {
        return stock + amount <= capacity;
    }

    public boolean canFetch(int amount) {
        return stock >= amount;
    }

    public void save(int amount) {
        stock += amount;
    }

    public void fetch(int amount) {
        stock -= amount;
    }

    @Override
    public String toString() {
        return "仓库" + id + "：" + stock + "/" + capacity;
    }
}
