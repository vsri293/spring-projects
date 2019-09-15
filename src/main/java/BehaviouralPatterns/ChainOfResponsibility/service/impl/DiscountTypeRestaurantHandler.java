package BehaviouralPatterns.ChainOfResponsibility.service.impl;

import BehaviouralPatterns.ChainOfResponsibility.dto.Restaurant;
import BehaviouralPatterns.ChainOfResponsibility.dto.SearchRequest;
import BehaviouralPatterns.ChainOfResponsibility.service.RestaurantHandler;

import java.util.ArrayList;
import java.util.List;

public class DiscountTypeRestaurantHandler extends RestaurantHandler {

    @Override
    protected void doFiltering(List<Restaurant> restaurants, SearchRequest searchRequest) {
        if (searchRequest.getDiscountType() != null){
            List<Restaurant> filterRestaurants = new ArrayList<>();
            for (Restaurant restaurant: restaurants){
                if (restaurant.getDiscountType().contains(searchRequest.getDiscountType())){
                    filterRestaurants.add(restaurant);
                }
            }
            restaurants.clear();
            restaurants.addAll(filterRestaurants);
        }
    }
}
