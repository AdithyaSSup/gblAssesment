package stratergy;

import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;

import java.util.ArrayList;
import java.util.List;

public class HighRatingPrimaryCuisineCostSorter implements RestaurantSortingStrategy {

    public List<Restaurant> sortRestaurants( User user,List<Restaurant> restaurants) {
        List<Restaurant> sortedRestaurants = new ArrayList<>();
        // Sort restaurants by primary cuisine primary cost bracket and rating >= 4
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getCuisine() == user.getPrimaryCuisine() && restaurant.getCostBracket() == user.getPrimaryCostBracket()
                    && restaurant.getRating() >= 4.0) {
                sortedRestaurants.add(restaurant);
                if(sortedRestaurants.size() >100){
                    break;
                }
            }
        }
        return sortedRestaurants;
    }
}
