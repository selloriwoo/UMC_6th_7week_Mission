package umc.PJR.converter;

import umc.PJR.domain.FoodType;
import umc.PJR.domain.mapping.FoodPreference;

import java.util.List;
import java.util.stream.Collectors;

public class FoodPreferenceConverter {
    public static List<FoodPreference> toFoodPreferenceList(List<FoodType> foodTypeList){

        return foodTypeList.stream()
                .map(foodType ->
                        FoodPreference.builder()
                                .foodType(foodType)
                                .build()
                ).collect(Collectors.toList());
    }
}
