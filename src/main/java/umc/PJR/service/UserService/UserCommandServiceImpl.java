package umc.PJR.service.UserService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.PJR.apiPayload.code.status.ErrorStatus;
import umc.PJR.apiPayload.exception.handler.FoodTypeHandler;
import umc.PJR.converter.FoodPreferenceConverter;
import umc.PJR.converter.UserConverter;
import umc.PJR.domain.FoodType;
import umc.PJR.domain.User;
import umc.PJR.domain.mapping.FoodPreference;
import umc.PJR.repository.FoodTypeRepository;
import umc.PJR.repository.UserRepository;
import umc.PJR.web.dto.UserRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserCommandServiceImpl implements UserCommandService{

    private final UserRepository userRepository;

    private final FoodTypeRepository foodTypeRepository;

    @Override
    @Transactional
    public User joinUser(UserRequestDTO.JoinDto request) {

        User newUser = UserConverter.toUser(request);
        List<FoodType> foodTypeList = request.getPreferType().stream()
                .map(type -> {
                    return foodTypeRepository.findById(type).orElseThrow(() -> new FoodTypeHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<FoodPreference> foodPreferenceList = FoodPreferenceConverter.toFoodPreferenceList(foodTypeList);

        foodPreferenceList.forEach(foodPreference -> {foodPreference.setUser(newUser);});

        return userRepository.save(newUser);
    }
}
