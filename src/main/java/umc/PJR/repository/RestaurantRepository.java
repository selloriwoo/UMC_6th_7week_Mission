package umc.PJR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.PJR.domain.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}
