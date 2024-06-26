package umc.PJR.service.RestaurantService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.PJR.converter.MissionConverter;
import umc.PJR.converter.RestaurantConverter;
import umc.PJR.converter.ReviewConverter;
import umc.PJR.converter.UserMissionConverter;
import umc.PJR.domain.Mission;
import umc.PJR.domain.Restaurant;
import umc.PJR.domain.Review;
import umc.PJR.domain.User;
import umc.PJR.domain.mapping.UserMission;
import umc.PJR.repository.*;
import umc.PJR.web.dto.RestaurantRequestDTO;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class RestaurantCommandServiceImpl implements RestaurantCommandService{

    private final RestaurantRepository restaurantRepository;
    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final MissionRepositoy missionRepositoy;
    private final UserMissionRepository userMissionRepository;
    @Override
    @Transactional
    public Restaurant joinRestaurant(RestaurantRequestDTO.JoinDto request){
        Restaurant newRestaurant = RestaurantConverter.toRestaurant(request);

        return restaurantRepository.save(newRestaurant);
    }

    @Override
    @Transactional
    public Review postReview(Long userId, Long restaurantId, RestaurantRequestDTO.PostReviewDTO request){
        Review newReview = ReviewConverter.toReview(request);

        newReview.setUser(userRepository.findById(userId).get());
        newReview.setRestaurant(restaurantRepository.findById(restaurantId).get());
        return reviewRepository.save(newReview);
    }

    @Override
    @Transactional
    public Mission addMission(Long restaurantId, RestaurantRequestDTO.AddMissionDTO request) {
        Mission newMission = MissionConverter.toMission(request);

        newMission.setRestaurant(restaurantRepository.findById(restaurantId).get());
        return missionRepositoy.save(newMission);
    }

    @Override
    @Transactional
    public UserMission challengeMission(Long userId, Long missionId){
        UserMission newUserMission;

        User user = userRepository.findById(userId).get();
        Mission mission = missionRepositoy.findById(missionId).get();
        newUserMission = UserMissionConverter.toUserMission(user, mission);

        return userMissionRepository.save(newUserMission);
    }
}
