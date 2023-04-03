package com.gbl.task.app;

import java.util.Date;

public class Restaurant {
    private String id;
    private Cuisine cuisine;
    private int costBracket;
    private float rating;
    private boolean isRecommended;
    private Date onboardedTime;

    public Restaurant(String restaurantId, Cuisine cuisine, int costBracket, float rating, boolean isRecommended, Date onboardedTime) {
        if (costBracket < 1 || costBracket > 5) {
            throw new IllegalArgumentException("Invalid cost bracket: " + costBracket);
        }
        this.id = restaurantId;
        this.cuisine = cuisine;
        this.costBracket = costBracket;
        this.rating = rating;
        this.isRecommended = isRecommended;
        this.onboardedTime = onboardedTime;
    }

    public String getId() {
        return id;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public int getCostBracket() {
        return costBracket;
    }

    public float getRating() {
        return rating;
    }

    public boolean isRecommended() {
        return isRecommended;
    }

    public Date getOnboardedTime() {
        return onboardedTime;
    }
}
