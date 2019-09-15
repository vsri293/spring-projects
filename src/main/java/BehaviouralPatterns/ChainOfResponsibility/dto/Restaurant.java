package BehaviouralPatterns.ChainOfResponsibility.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Restaurant {
    private List<FoodType> foodType;
    private List<DiscountType> discountType;
}
