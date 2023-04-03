package com.gbl.strategy;

import com.gbl.app.Restaurant;
import com.gbl.app.User;

import java.util.List;

public interface RestaurantSortingStrategy {
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> restaurants);
}
