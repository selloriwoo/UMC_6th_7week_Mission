package umc.PJR.converter;

import org.springframework.data.domain.Page;
import umc.PJR.domain.Review;
import umc.PJR.web.dto.RestaurantRequestDTO;
import umc.PJR.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ReviewConverter {

    public static Review toReview(RestaurantRequestDTO.PostReviewDTO request){

        return Review.builder()
                //.user(request.getUserId()) fk하는법 알아야함
                .content(request.getContent())
                .starPoint(request.getStarPoint())
                .build();
    }
    public static RestaurantResponseDTO.PostReviewDTO toPostResultDTO(Review review){
        return RestaurantResponseDTO.PostReviewDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewDTO reviewPreViewDTO(Review review){
        return RestaurantResponseDTO.ReviewPreViewDTO.builder()
                .nickname(review.getUser().getNickname())
                .score(review.getStarPoint())
                .createdAt(review.getCreatedAt().toLocalDate())
                .content(review.getContent())
                .build();
    }
    public static RestaurantResponseDTO.ReviewPreViewListDTO reviewPreViewListDTO(Page<Review> reviewList){
        List<RestaurantResponseDTO.ReviewPreViewDTO> reviewPreViewDTOList = reviewList.stream()
                .map(ReviewConverter::reviewPreViewDTO).collect(Collectors.toList());

        return RestaurantResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviewList.isLast())
                .isFirst(reviewList.isFirst())
                .totalPage(reviewList.getTotalPages())
                .totalElements(reviewList.getTotalElements())
                .listSize(reviewPreViewDTOList.size())
                .reviewList(reviewPreViewDTOList)
                .build();
    }
}
