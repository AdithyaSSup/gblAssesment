package com.gbl.task.strategy;

import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;

import java.util.List;

public class AllRestaurantSorter implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> sortRestaurants(User User ,List<Restaurant> restaurants) {
        return restaurants;
    }
}