package umc.PJR.service.UserService;

import umc.PJR.domain.User;
import umc.PJR.web.dto.UserRequestDTO;

public interface UserCommandService  {

    User joinUser(UserRequestDTO.JoinDto request);
}
