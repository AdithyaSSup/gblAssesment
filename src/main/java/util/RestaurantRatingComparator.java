package util;

import com.gbl.task.app.Restaurant;

import java.util.Comparator;

public class RestaurantRatingComparator implements Comparator<Restaurant> {
    @Override
    public int compare(Restaurant r1, Restaurant r2) {
        // Compare the ratings of the two restaurants
        if (r1.getRating() < r2.getRating()) {
            return 1;
        } else if (r1.getRating() > r2.getRating()) {
            return -1;
        }
        return 0;
    }
}