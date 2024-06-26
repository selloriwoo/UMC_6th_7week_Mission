package umc.PJR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.PJR.domain.Mission;

public interface MissionRepositoy extends JpaRepository<Mission, Long> {
}
