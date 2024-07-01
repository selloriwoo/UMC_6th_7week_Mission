package umc.PJR.converter;

import umc.PJR.domain.Mission;
import umc.PJR.web.dto.RestaurantRequestDTO;
import umc.PJR.web.dto.RestaurantResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static Mission toMission(RestaurantRequestDTO.AddMissionDTO request){
        return Mission.builder()
                .content(request.getContent())
                .needPay(request.getNeedPay())
                .getPoint(request.getGetPoint())
                .build();
    }

    public static RestaurantResponseDTO.AddMissionDTO toAddMissionDTO(Mission mission){
        return RestaurantResponseDTO.AddMissionDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
