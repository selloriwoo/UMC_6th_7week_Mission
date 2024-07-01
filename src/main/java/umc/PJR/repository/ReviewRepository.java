package umc.PJR.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.PJR.domain.Restaurant;
import umc.PJR.domain.Review;
import umc.PJR.domain.User;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Page<Review> findAllByRestaurant(Restaurant restaurant, PageRequest pageRequest);
    Page<Review> findAllByUser(User user, PageRequest pageRequest);
}
