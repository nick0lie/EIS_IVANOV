package Lab5_Annotation_Validation.Validator;

import Lab5_Annotation_Validation.Annotation.ValidParkPriority;
import Lab5_Annotation_Validation.Model.Park;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ParkPriorityValidator implements ConstraintValidator<ValidParkPriority, Park> {

    @Override
    public boolean isValid(Park park, ConstraintValidatorContext context) {
        if (park.getTransitTrainPriority() == null || park.getDisbandTrainPriority() == null) {
            return true; // Null-поля обрабатываются другими аннотациями
        }
        // Проверяем, что хотя бы одно из полей не равно нулю
        return park.getTransitTrainPriority() != 0 || park.getDisbandTrainPriority() != 0;
    }
}
