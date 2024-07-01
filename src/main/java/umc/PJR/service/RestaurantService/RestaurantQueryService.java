package umc.PJR.service.RestaurantService;

import org.springframework.data.domain.Page;
import umc.PJR.domain.Restaurant;
import umc.PJR.domain.Review;

import java.util.Optional;

public interface RestaurantQueryService {

    Optional<Restaurant> findRestaurant(Long id);

    Page<Review> getReviewList(Long restaurantId, Integer page);
}
