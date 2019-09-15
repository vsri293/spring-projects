package BehaviouralPatterns.ChainOfResponsibility;

import BehaviouralPatterns.ChainOfResponsibility.dto.DiscountType;
import BehaviouralPatterns.ChainOfResponsibility.dto.FoodType;
import BehaviouralPatterns.ChainOfResponsibility.dto.Restaurant;
import BehaviouralPatterns.ChainOfResponsibility.dto.SearchRequest;
import BehaviouralPatterns.ChainOfResponsibility.service.NormalRestaurantHandlerChain;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        List<Restaurant> restaurants = new ArrayList<>();
        List<DiscountType> aDiscountTypes = new ArrayList<>();
        List<FoodType> aFoodTypes = new ArrayList<>();
        aDiscountTypes.add(DiscountType.HDFC_BANK);
        aFoodTypes.add(FoodType.VEG);
        Restaurant a =  Restaurant.builder().discountType(aDiscountTypes).foodType(aFoodTypes).build();
        restaurants.add(a);
        List<DiscountType> bDiscountTypes = new ArrayList<>();
        List<FoodType> bFoodTypes = new ArrayList<>();
        bDiscountTypes.add(DiscountType.HDFC_BANK);
        bFoodTypes.add(FoodType.NON_VEG);
        Restaurant b = Restaurant.builder().discountType(bDiscountTypes).foodType(bFoodTypes).build();
        restaurants.add(b);
        System.out.println(restaurants);
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.setDiscountType(DiscountType.HDFC_BANK);
        searchRequest.setFoodType(FoodType.NON_VEG);
        NormalRestaurantHandlerChain normalRestaurantHandlerChain = new NormalRestaurantHandlerChain();
        normalRestaurantHandlerChain.filter(restaurants, searchRequest);
        System.out.println(restaurants);
    }
}
