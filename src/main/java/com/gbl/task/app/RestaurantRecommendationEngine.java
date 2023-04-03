package com.gbl.task.app;

import strategy.RestaurantSortingStrategy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RestaurantRecommendationEngine {
    private List<RestaurantSortingStrategy> sortingStrategies;

    public RestaurantRecommendationEngine(List<RestaurantSortingStrategy> sortingStrategies) {
        this.sortingStrategies = sortingStrategies;
    }

    public List<String> getRestaurantRecommendations(User user, List<Restaurant> availableRestaurants) {
        Set<String> recommendedIds = new HashSet<>();

        // Iterate over each sorting strategy and apply it to the available restaurants
        for (RestaurantSortingStrategy strategy : sortingStrategies) {
            List<Restaurant> sortedRestaurants = strategy.sortRestaurants(user, availableRestaurants);

            // Add unique restaurant IDs to the recommendedIds set
            for (Restaurant restaurant : sortedRestaurants) {
                if (!recommendedIds.contains(restaurant.getId())) {
                    recommendedIds.add(restaurant.getId());

                    if (recommendedIds.size() == 100) {
                        return new ArrayList<>(recommendedIds);
                    }
                }
            }
        }

        // If we have less than 100 unique restaurant IDs, return all the recommended IDs
        return new ArrayList<>(recommendedIds);
    }
}
