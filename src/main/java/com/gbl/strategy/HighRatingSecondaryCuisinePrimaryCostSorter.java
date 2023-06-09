package com.gbl.strategy;

import com.gbl.app.Cuisine;
import com.gbl.app.Restaurant;
import com.gbl.app.User;
import com.gbl.util.RestaurantRatingComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HighRatingSecondaryCuisinePrimaryCostSorter implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> restaurants) {
        List<Restaurant> sortedRestaurants = new ArrayList<>();

        List<Cuisine> secondaryCuisines = user.getSecondaryCuisines();
        int primaryCostBracket = user.getPrimaryCostBracket();

        for (Restaurant restaurant : restaurants) {
            if (secondaryCuisines.contains(restaurant.getCuisine()) &&
                    restaurant.getCostBracket() == primaryCostBracket &&
                    restaurant.getRating() >= 4.5) {
                sortedRestaurants.add(restaurant);
                if(sortedRestaurants.size() >100){
                    break;
                }
            }
        }

        Collections.sort(sortedRestaurants, new RestaurantRatingComparator().reversed());
        return sortedRestaurants;
    }
}

