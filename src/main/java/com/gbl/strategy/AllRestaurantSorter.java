package com.gbl.strategy;

import com.gbl.app.Restaurant;
import com.gbl.app.User;

import java.util.List;

public class AllRestaurantSorter implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> sortRestaurants(User User , List<Restaurant> restaurants) {
        return restaurants;
    }
}