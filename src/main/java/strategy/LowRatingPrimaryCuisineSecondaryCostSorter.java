package strategy;

import com.gbl.task.app.Cuisine;
import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;
import util.RestaurantRatingComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LowRatingPrimaryCuisineSecondaryCostSorter implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> sortRestaurants(User user,List<Restaurant> restaurants) {
        List<Restaurant> sortedRestaurants = new ArrayList<>();
        Cuisine primaryCuisine = user.getPrimaryCuisine();
        int[] secondaryCostBrackets = user.getSecondaryCostBrackets();

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getCuisine().equals(primaryCuisine)
                    && Arrays.stream(secondaryCostBrackets).anyMatch(c -> c == restaurant.getCostBracket())
                    && restaurant.getRating() < 4.5) {
                sortedRestaurants.add(restaurant);
                if(sortedRestaurants.size() >100){
                    break;
                }
            }
        }

        sortedRestaurants.sort(new RestaurantRatingComparator());
        return sortedRestaurants;
    }
}
