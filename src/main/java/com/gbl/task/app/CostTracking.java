package com.gbl.task.app;

public class CostTracking {
    private int type;
    private int noOfOrders;

    public CostTracking(int type, int noOfOrders) {
        this.type = type;
        this.noOfOrders = noOfOrders;
    }

    public int getType() {
        return type;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void incrementOrder() {
        this.noOfOrders++;
    }
}
