package BehaviouralPatterns.ChainOfResponsibility.service.impl;

import BehaviouralPatterns.ChainOfResponsibility.dto.Restaurant;
import BehaviouralPatterns.ChainOfResponsibility.dto.SearchRequest;
import BehaviouralPatterns.ChainOfResponsibility.service.RestaurantHandler;

import java.util.ArrayList;
import java.util.List;

public class FoodTypeRestaurantHandler extends RestaurantHandler {
    @Override
    protected void doFiltering(List<Restaurant> restaurants, SearchRequest searchRequest) {
        if (searchRequest.getFoodType() != null){
            List<Restaurant> filterRestaurants = new ArrayList<>();
            for (Restaurant restaurant: restaurants){
                if (restaurant.getFoodType().contains(searchRequest.getFoodType())){
                    filterRestaurants.add(restaurant);
                }
            }
            restaurants.clear();
            restaurants.addAll(filterRestaurants);
        }
    }
}
