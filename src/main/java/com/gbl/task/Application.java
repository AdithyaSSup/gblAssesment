package com.gbl.task;

import com.gbl.task.app.*;
import stratergy.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Application {

    public static void main(String[] args) {

        List<Restaurant> restaurants = createRandomRestaurants(20);

        User user = createUser(restaurants);

        System.out.println(" primary cuisine of user : "+ user.getPrimaryCuisine());
        System.out.println(" primary costBracket user : "+ user.getPrimaryCostBracket());

        List<RestaurantSortingStrategy> sortingStrategies = createSortingStrategies();

        RestaurantRecommendationEngine engine = new RestaurantRecommendationEngine(sortingStrategies);

        List<String> recommendations = engine.getRestaurantRecommendations(user, restaurants);

        System.out.println("total recommended restaurants "+ recommendations.size());

        recommendations.forEach( rst ->
                System.out.println(" restaurant id "+rst)
        );

    }

    private static User createUser(List<Restaurant> restaurants) {
        User user = new User( new CuisineTracking[]{}, new CostTracking[]{}, new Random().nextInt(1000));
        for( int i =0; i< 10 ; i++){
            System.out.println("User : "+user.getId()+" Ordering From Restaurant id:"
                    +restaurants.get(i).getId()+" , cuisine " +restaurants.get(i).getCuisine()
                    +", is recommended :" +restaurants.get(i).isRecommended()+", cost bracket :"
                    +restaurants.get(i).getCostBracket()+" Rating :"
                    +restaurants.get(i).getRating());
            user.updateTrackers(restaurants.get(i));
        }
        return user;
    }

    private static List<Restaurant> createRandomRestaurants(int count) {
        List<Restaurant> restaurants = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            String id = "R" + i;
            String name = "Restaurant " + i;
            int costBracket = new Random().nextInt(5) + 1;
            Cuisine cuisine = (Cuisine.values()[(int) (Math.random() * Cuisine.values().length)]);
            float rating = new Random().nextFloat() * 5.0f;
            boolean isRecommended = new Random().nextBoolean();
            Date onboardedTime = new Date();
            restaurants.add(new Restaurant(id, cuisine,costBracket,rating,isRecommended,onboardedTime));
        }
        return restaurants;
    }



    private static List<RestaurantSortingStrategy> createSortingStrategies() {
        // Filtering Steps can be configured here
        // Each class is filtering step returning list of restaurant ids.
        List<RestaurantSortingStrategy> sortingStrategies = new ArrayList<>();
        sortingStrategies.add(new FeaturedRestaurantsSorter());
        sortingStrategies.add(new HighRatingPrimaryCuisineCostSorter());
        sortingStrategies.add(new HighRatingPrimaryCuisineSecondaryCostSorter());
        sortingStrategies.add(new HighRatingSecondaryCuisinePrimaryCostSorter());
        sortingStrategies.add(new NewRestaurantSorter());
        sortingStrategies.add(new LowRatingPrimaryCuisinePrimaryCostSorter());
        sortingStrategies.add(new LowRatingPrimaryCuisineSecondaryCostSorter());
        sortingStrategies.add(new LowRatingSecondaryCuisinePrimaryCostSorter());
        sortingStrategies.add(new AllRestaurantSorter());
        return sortingStrategies;
    }
}
