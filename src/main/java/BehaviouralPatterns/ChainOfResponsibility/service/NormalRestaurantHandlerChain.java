package BehaviouralPatterns.ChainOfResponsibility.service;

import BehaviouralPatterns.ChainOfResponsibility.dto.Restaurant;
import BehaviouralPatterns.ChainOfResponsibility.dto.SearchRequest;
import BehaviouralPatterns.ChainOfResponsibility.service.impl.DiscountTypeRestaurantHandler;
import BehaviouralPatterns.ChainOfResponsibility.service.impl.FoodTypeRestaurantHandler;

import java.util.List;

public class NormalRestaurantHandlerChain {
    private RestaurantHandler foodTypeRestaurantHandler;
    private RestaurantHandler discountTypeRestaurantHandler;

    public NormalRestaurantHandlerChain() {
         this.foodTypeRestaurantHandler = new FoodTypeRestaurantHandler();
         this.discountTypeRestaurantHandler = new DiscountTypeRestaurantHandler();
         foodTypeRestaurantHandler.setNext(discountTypeRestaurantHandler);
    }

    public void filter(List<Restaurant> restaurants, SearchRequest searchRequest) {
        foodTypeRestaurantHandler.filter(restaurants, searchRequest);
    }
}
