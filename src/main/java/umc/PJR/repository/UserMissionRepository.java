package umc.PJR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.PJR.domain.mapping.UserMission;

public interface UserMissionRepository extends JpaRepository<UserMission, Long> {
}
