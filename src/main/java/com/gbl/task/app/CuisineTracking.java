package com.gbl.task.app;

import com.gbl.task.app.Cuisine;

public class CuisineTracking {
    private Cuisine type;
    private int noOfOrders;

    public CuisineTracking(Cuisine type, int noOfOrders) {
        this.type = type;
        this.noOfOrders = noOfOrders;
    }

    public Cuisine getType() {
        return type;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }

    public void increementOrder() {
        this.noOfOrders++;
    }
}
