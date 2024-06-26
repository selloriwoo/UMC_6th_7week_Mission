package umc.PJR.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class RestaurantRequestDTO {

    @Getter
    public static class JoinDto {
        @NotBlank
        String name;
        @NotNull
        String restaurantType;
        @Size(min = 5, max = 12)
        String address;
        @Size(min = 5, max = 12)
        String specAddress;

        //String photo; 사진은 보류

    }
    @Getter
    public static class PostReviewDTO {
        //@NotBlank
        //String UserId;
        @NotNull
        String content;
        @NotNull
        Float starPoint;
//        @Size(min = 5, max = 12)
//        String photo;

    }

    @Getter
    public static class AddMissionDTO{
        @NotNull
        String content;
        @NotNull
        Integer getPoint;
        @NotNull
        Integer needPay;
//        @NotNull
//        Integer endYear;
//        @NotNull
//        Integer endMonth;
//        @NotNull
//        Integer endDay;
    }
}
