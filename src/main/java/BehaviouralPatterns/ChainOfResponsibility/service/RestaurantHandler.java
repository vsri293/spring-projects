package BehaviouralPatterns.ChainOfResponsibility.service;

import BehaviouralPatterns.ChainOfResponsibility.dto.Restaurant;
import BehaviouralPatterns.ChainOfResponsibility.dto.SearchRequest;

import java.util.List;

public abstract class RestaurantHandler {
    private RestaurantHandler nextRestaurantHeandler;

    public void filter(List<Restaurant> restaurants, SearchRequest searchRequest){
        if (restaurants.size() > 0) {
            doFiltering(restaurants, searchRequest);
        }
        if (nextRestaurantHeandler != null) {
            nextRestaurantHeandler.filter(restaurants, searchRequest);
        }
    }

    protected abstract void doFiltering(List<Restaurant> restaurants, SearchRequest searchRequest);

    public void setNext(RestaurantHandler restaurantHandler){
        this.nextRestaurantHeandler = restaurantHandler;
    }
}
