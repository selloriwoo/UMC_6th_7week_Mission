//package umc.PJR.service.ReviewService;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import umc.PJR.converter.ReviewConverter;
//import umc.PJR.domain.Review;
//import umc.PJR.repository.RestaurantRepository;
//import umc.PJR.repository.ReviewRepository;
//import umc.PJR.web.dto.ReviewRequestDTO;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class ReviewCommandServiceImpl implements ReviewCommandService{
//    private final ReviewRepository reviewRepository;
//
//    private final RestaurantRepository restaurantRepository;
//
////    @Override
////    @Transactional
////    public Review joinReview (ReviewRequestDTO.JoinDto request){
////        Review newReview = ReviewConverter.toReview(request);
////
////        return reviewRepository.save(newReview);
////    }
//}
