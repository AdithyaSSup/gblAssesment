package strategy;

import com.gbl.task.app.Cuisine;
import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;

import java.util.ArrayList;
import java.util.List;

public class FeaturedRestaurantsSorter implements RestaurantSortingStrategy {

    public List<Restaurant> sortRestaurants(User user,List<Restaurant> restaurants) {
        List<Restaurant> sortedRestaurants = new ArrayList<>();
        // filter featured restaurants of primary cuisine and primary cost bracket
        for (Restaurant restaurant : restaurants) {
            if (restaurant.isRecommended() && restaurant.getCuisine() == user.getPrimaryCuisine()
                    && restaurant.getCostBracket() == user.getPrimaryCostBracket()) {
                sortedRestaurants.add(restaurant);
                if(sortedRestaurants.size() >100){
                    break;
                }
            }
        }
        // if no featured restaurants of primary cuisine and primary cost bracket found,
        // then filter featured restaurants of primary cuisine, secondary cost and secondary cuisine, primary cost
        if (sortedRestaurants.isEmpty()) {
            List<Cuisine> secondaryCuisines = user.getSecondaryCuisines();
            int[] secondaryCostBrackets = user.getSecondaryCostBrackets();
            for (Restaurant restaurant : restaurants) {
                if (restaurant.isRecommended() && (restaurant.getCuisine() == user.getPrimaryCuisine() ||
                        secondaryCuisines.contains(restaurant.getCuisine())) &&
                        (restaurant.getCostBracket() == user.getPrimaryCostBracket() ||
                                restaurant.getCostBracket() == secondaryCostBrackets[0] ||
                                restaurant.getCostBracket() == secondaryCostBrackets[1])) {
                    sortedRestaurants.add(restaurant);
                    if(sortedRestaurants.size() >100){
                        break;
                    }
                }
            }
        }
        return sortedRestaurants;
    }
}
