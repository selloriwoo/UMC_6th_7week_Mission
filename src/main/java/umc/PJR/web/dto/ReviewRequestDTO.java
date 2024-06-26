package umc.PJR.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDto {
        //@NotBlank
        //String UserId;
        @NotNull
        float starPoint;

        @NotBlank
        String content;
//        @Size(min = 5, max = 12)
//        String photo;

    }
}