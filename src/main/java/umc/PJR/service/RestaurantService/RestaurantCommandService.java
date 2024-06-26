package umc.PJR.service.RestaurantService;

import umc.PJR.domain.Mission;
import umc.PJR.domain.Restaurant;
import umc.PJR.domain.Review;
import umc.PJR.domain.mapping.UserMission;
import umc.PJR.web.dto.RestaurantRequestDTO;

public interface RestaurantCommandService {
    Restaurant joinRestaurant(RestaurantRequestDTO.JoinDto request);

    Review postReview(Long UserId, Long restaurantId, RestaurantRequestDTO.PostReviewDTO request);

    Mission addMission(Long restaurantId, RestaurantRequestDTO.AddMissionDTO request);

    UserMission challengeMission(Long userId, Long missionId);
}
