package Lab5_Annotation_Validation.Annotation;

import Lab5_Annotation_Validation.Validator.ParkPriorityValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ParkPriorityValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidParkPriority {
    String message() default "Оба приоритета приёма поездов не могут одновременно быть равны нулю";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
