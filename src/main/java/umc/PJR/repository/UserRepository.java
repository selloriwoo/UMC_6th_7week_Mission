package umc.PJR.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.PJR.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
