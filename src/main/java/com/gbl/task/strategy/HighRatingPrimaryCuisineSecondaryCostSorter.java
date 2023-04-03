package com.gbl.task.strategy;

import com.gbl.task.app.Cuisine;
import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;
import com.gbl.task.util.RestaurantRatingComparator;

import java.util.*;

public class HighRatingPrimaryCuisineSecondaryCostSorter implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> sortRestaurants(User user,List<Restaurant> restaurants) {
        List<Restaurant> sortedRestaurants = new ArrayList<>();

        Cuisine primaryCuisine = user.getPrimaryCuisine();
        int[] secondaryCostBracket = user.getSecondaryCostBrackets();

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getCuisine() == primaryCuisine &&
                    Arrays.binarySearch(secondaryCostBracket, restaurant.getCostBracket()) >= 0 &&
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

