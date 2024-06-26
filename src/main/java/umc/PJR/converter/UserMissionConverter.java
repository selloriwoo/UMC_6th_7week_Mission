package umc.PJR.converter;

import umc.PJR.domain.Mission;
import umc.PJR.domain.User;
import umc.PJR.domain.enums.MissionStatus;
import umc.PJR.domain.mapping.UserMission;
import umc.PJR.web.dto.RestaurantResponseDTO;

public class UserMissionConverter {

    public static UserMission toUserMission(User user, Mission mission){
        return UserMission.builder()
                .user(user)
                .mission(mission)
                .status(MissionStatus.valueOf("CHALLENGING"))
                .build();
    }

    public static RestaurantResponseDTO.ChallengeMissionDTO toUserMissionResult(UserMission userMission){
        return RestaurantResponseDTO.ChallengeMissionDTO.builder()
                .userMissionId(userMission.getId())
                .createdAt(userMission.getCreatedAt())
                .build();
    }
}
