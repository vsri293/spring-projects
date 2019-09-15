package BehaviouralPatterns.ChainOfResponsibility.dto;

import lombok.Data;

@Data
public class SearchRequest {
    private FoodType foodType;
    private DiscountType discountType;
}
