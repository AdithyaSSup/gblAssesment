package com.gbl.strategy;

import com.gbl.app.Restaurant;
import com.gbl.app.User;
import com.gbl.util.RestaurantRatingComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class NewRestaurantSorter implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> restaurants) {
        List<Restaurant> newRestaurants = new ArrayList<>();
        List<Restaurant> sortedRestaurants = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            if (isRestaurantNew(restaurant)) {
                newRestaurants.add(restaurant);
                if(newRestaurants.size() >100){
                    break;
                }
            }
        }
        // Sort the list based on rating
        Collections.sort(newRestaurants, new RestaurantRatingComparator().reversed());

        //Get top 4
        sortedRestaurants.addAll(newRestaurants.subList(0, Math.min(newRestaurants.size(), 4)));
        return sortedRestaurants;
    }

    private boolean isRestaurantNew(Restaurant restaurant) {
        long differenceInMs = new Date().getTime() - restaurant.getOnboardedTime().getTime();
        long differenceInHours = TimeUnit.HOURS.convert(differenceInMs, TimeUnit.MILLISECONDS);
        return differenceInHours < 48;
    }
}
