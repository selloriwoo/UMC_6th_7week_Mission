package umc.PJR.converter;

import umc.PJR.domain.Restaurant;
import umc.PJR.web.dto.RestaurantRequestDTO;
import umc.PJR.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class RestaurantConverter {

    public static RestaurantResponseDTO.JoinResultDTO toJoinResultDTO(Restaurant restaurant){
        return RestaurantResponseDTO.JoinResultDTO.builder()
                .restaurantId(restaurant.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Restaurant toRestaurant(RestaurantRequestDTO.JoinDto request){

        return Restaurant.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .restaurantType(request.getRestaurantType())
                .name(request.getName())
                .build();
    }

}
