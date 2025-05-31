public class RentalOrder {
    private Car car;
    private int days;

    public RentalOrder(Car car, int days) {
        this.car = car;
        this.days = days;
    }

    public Car getCar() {
        return car;
    }

    public int getDays() {
        return days;
    }

    public int calculateTotal() {
        return car.totalcost(days);
    }
}