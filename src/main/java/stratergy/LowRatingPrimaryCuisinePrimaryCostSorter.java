package stratergy;

import com.gbl.task.app.Cuisine;
import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;
import util.RestaurantRatingComparator;

import java.util.ArrayList;
import java.util.List;

public class LowRatingPrimaryCuisinePrimaryCostSorter implements RestaurantSortingStrategy {

    @Override
    public List<Restaurant> sortRestaurants(User user,List<Restaurant> restaurants) {
        List<Restaurant> sortedRestaurants = new ArrayList<>();
        Cuisine primaryCuisine = user.getPrimaryCuisine();
        int primaryCostBracket = user.getPrimaryCostBracket();

        for (Restaurant restaurant : restaurants) {
            if (restaurant.getCuisine().equals(primaryCuisine)
                    && restaurant.getCostBracket() == primaryCostBracket
                    && restaurant.getRating() < 4) {
                sortedRestaurants.add(restaurant);
            }
            if(sortedRestaurants.size() >100){
                break;
            }

        }

        sortedRestaurants.sort(new RestaurantRatingComparator());
        return sortedRestaurants;
    }
}
