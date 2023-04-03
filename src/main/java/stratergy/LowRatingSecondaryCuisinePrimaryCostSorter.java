package stratergy;

import com.gbl.task.app.Cuisine;
import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;
import util.RestaurantRatingComparator;

import java.util.ArrayList;
import java.util.List;

public class LowRatingSecondaryCuisinePrimaryCostSorter implements RestaurantSortingStrategy {
    @Override
    public List<Restaurant> sortRestaurants(User user,List<Restaurant> restaurants) {
        List<Restaurant> sortedRestaurants = new ArrayList<>();
        List<Cuisine> secondaryCuisines = user.getSecondaryCuisines();
        int primaryCostBracket = user.getPrimaryCostBracket();

        for (Restaurant restaurant : restaurants) {
            if (secondaryCuisines.contains(restaurant.getCuisine())
                    && restaurant.getCostBracket() == primaryCostBracket
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
