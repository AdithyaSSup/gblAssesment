package stratergy;

import com.gbl.task.app.Restaurant;
import com.gbl.task.app.User;

import java.util.List;

public interface RestaurantSortingStrategy {
    public List<Restaurant> sortRestaurants(User user, List<Restaurant> restaurants);
}
