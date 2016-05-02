package edu.multithreading.Lock;

/**
 * Created by eitukshaitov on 02.05.2016.
 */
class Order {
    private int id;
    private OrderStatus status;

    public Order(int sharedInt, OrderStatus sharedString) {
        this.id = sharedInt;
        this.status = sharedString;
    }

    public Order() {
        this.status = OrderStatus.NONE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }
}
