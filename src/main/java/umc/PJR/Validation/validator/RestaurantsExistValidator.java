//package umc.PJR.Validation.validator;
//
//import jakarta.validation.ConstraintValidator;
//import jakarta.validation.ConstraintValidatorContext;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Component;
//import umc.PJR.Validation.validator.annotation.ExistRestaurants;
//import umc.PJR.apiPayload.code.status.ErrorStatus;
//import umc.PJR.repository.RestaurantRepository;
//
//@Component
//@RequiredArgsConstructor
//public class RestaurantsExistValidator implements ConstraintValidator<ExistRestaurants, Long> {
//
//    private final RestaurantRepository restaurantRepository;
//
//    @Override
//    public void initialize(ExistRestaurants constraintAnnotation) {
//        ConstraintValidator.super.initialize(constraintAnnotation);
//    }
//
//    @Override
//    public boolean isValid(Long value, ConstraintValidatorContext context) {
//        boolean isValid = restaurantRepository.existsById(value);
//
//        if (!isValid) {
//            context.disableDefaultConstraintViolation();
//            context.buildConstraintViolationWithTemplate(ErrorStatus.Restaurant_NOT_FOUND.toString()).addConstraintViolation();
//        }
//
//        return isValid;
//
//    }
//}