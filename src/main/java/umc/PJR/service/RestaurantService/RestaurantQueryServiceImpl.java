package umc.PJR.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.PJR.domain.Restaurant;
import umc.PJR.domain.Review;
import umc.PJR.domain.User;
import umc.PJR.repository.RestaurantRepository;
import umc.PJR.repository.ReviewRepository;
import umc.PJR.repository.UserRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantQueryServiceImpl implements RestaurantQueryService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    @Override
    public Optional<Restaurant> findRestaurant(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Page<Review> getReviewList(Long restaurantId, Integer page) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Page<Review> restaurantPage = reviewRepository.findAllByRestaurant(restaurant, PageRequest.of(page, 10));

        return restaurantPage;
    }

    @Override
    public Page<Review> getUserReviewList(Long userId, Integer page) {
        User user = userRepository.findById(userId).get();

        Page<Review> userReviewPage = reviewRepository.findAllByUser(user, PageRequest.of(page, 10));

        return userReviewPage;
    }
}
