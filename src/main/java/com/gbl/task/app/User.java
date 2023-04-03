package com.gbl.task.app;

import com.gbl.task.app.CostTracking;
import com.gbl.task.app.Cuisine;
import com.gbl.task.app.CuisineTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class User {
    private int id;
    private CuisineTracking[] cuisines;
    private CostTracking[] costBrackets;

    public User(CuisineTracking[] cuisines, CostTracking[] costBracket, int id) {
        this.cuisines = cuisines;
        this.costBrackets = costBracket;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public CuisineTracking[] getCuisines() {
        return cuisines;
    }

    public CostTracking[] getCostBrackets() {
        return costBrackets;
    }

    public Cuisine getPrimaryCuisine() {
        if (cuisines.length > 0) {
            return cuisines[0].getType();
        }
        return null;
    }

    public List<Cuisine> getSecondaryCuisines() {
        List<Cuisine> secondaryCuisine = new ArrayList<>();
        if (cuisines.length > 1) {
            secondaryCuisine.add(cuisines[1].getType());
            secondaryCuisine.add(cuisines.length > 2 ? cuisines[2].getType() : null);
        }
        return secondaryCuisine;
    }

    public int getPrimaryCostBracket() {
        if (costBrackets.length > 0) {
            return costBrackets[0].getType();
        }
        System.out.println(" Issyue here "+costBrackets.length);
        return -1;
    }

    public int[] getSecondaryCostBrackets() {
        if (costBrackets.length > 1) {
            return new int[]{costBrackets[1].getType(), costBrackets.length > 2 ? costBrackets[2].getType() : -1};
        }
        return null;
    }

    public void updateTrackers(Restaurant restaurant) {
        Cuisine restaurantCuisine = restaurant.getCuisine();
        int restaurantCost = restaurant.getCostBracket();
        boolean cuisineFound = false;
        for (CuisineTracking cuisineTracking : this.cuisines) {
            if (cuisineTracking.getType() == restaurantCuisine) {
                cuisineTracking.increementOrder();
                cuisineFound = true;
                break;
            }
        }
        if (!cuisineFound) {
            CuisineTracking newCuisineTracking = new CuisineTracking(restaurantCuisine, 1);
            CuisineTracking[] updatedCuisines = Arrays.copyOf(this.cuisines, this.cuisines.length + 1);
            updatedCuisines[this.cuisines.length] = newCuisineTracking;
            this.cuisines = updatedCuisines;
        }

        boolean costFound = false;
        for (CostTracking costTracking : costBrackets) {
            if (costTracking.getType() == restaurantCost) {
                costTracking.incrementOrder();
                costFound = true;
                break;
            }
        }
        if (!costFound) {
            CostTracking newCostTracking = new CostTracking(restaurantCost, 1);
            CostTracking[] updatedCosts = Arrays.copyOf(costBrackets, costBrackets.length + 1);
            updatedCosts[costBrackets.length] = newCostTracking;
            this.costBrackets = updatedCosts;
        }

        //Sort by order count
        Arrays.sort(this.cuisines, Comparator.comparing(CuisineTracking::getNoOfOrders).reversed());

        Arrays.sort(this.costBrackets, Comparator.comparing(CostTracking::getNoOfOrders).reversed());
    }
}
