package umc.PJR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.PJR.domain.FoodType;

public interface FoodTypeRepository extends JpaRepository<FoodType, Long> {
}
