package edu.multithreading.Lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eitukshaitov on 02.05.2016.
 */
class Order {
    private int id;
    private OrderStatus status;
    private boolean[] priorities;

    public Order(int sharedInt, OrderStatus sharedString) {
        this.id = sharedInt;
        this.status = sharedString;
    }

    public Order(int sharedInt, OrderStatus sharedString, int prioritiesSize) {
        this.id = sharedInt;
        this.status = sharedString;
        this.priorities = new boolean[prioritiesSize];
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

    public void setPriority(int index, boolean priority){
        if(this.priorities != null) {
            this.priorities[index] = priority;
        }
    }

    public boolean getPriority(int index){
        if(this.priorities != null)
            return this.priorities[index];
        else
            return false;
    }
}
