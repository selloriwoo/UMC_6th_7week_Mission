//package umc.PJR.Validation.validator.annotation;
//
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//import umc.PJR.Validation.validator.CategoriesExistValidator;
//
//import java.lang.annotation.*;
//
//@Documented
//@Constraint(validatedBy = CategoriesExistValidator.class)
//@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
//@Retention(RetentionPolicy.RUNTIME)
//public @interface ExistRestaurants {
//
//    String message() default "해당하는 가게가 존재하지 않습니다.";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//}