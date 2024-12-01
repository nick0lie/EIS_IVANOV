package Lab4_Validation;

import Lab4_Validation.Model.XmlValidatedPark;
import Lab4_Validation.Model.CodeValidatedPark;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

import java.util.Set;

public class Laboratory4 {

    public static void main(String[] args) {
        ValidatorFactory factory = Validation.byProvider(HibernateValidator.class)
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        XmlValidatedPark xmlPark = new XmlValidatedPark();
        xmlPark.setName("Центральный");
        xmlPark.setAddress("г. Москва, ул. Тверская, 1");
        xmlPark.setNumberOfTrees(500);
        xmlPark.setParkType("Городской");

        System.out.println("Валидация XmlValidatedPark:");
        validateAndPrint(validator, xmlPark);

        CodeValidatedPark codePark = new CodeValidatedPark();
        codePark.setName("1234"); // Некорректное имя
        codePark.setAddress(null); // Поле не должно быть пустым
        codePark.setNumberOfTrees(15000); // Некорректное значение
        codePark.setParkType("Промышленный"); // Некорректный тип

        System.out.println("\nВалидация CodeValidatedPark:");
        validateAndPrint(validator, codePark);
    }

    private static <T> void validateAndPrint(Validator validator, T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (violations.isEmpty()) {
            System.out.println("Валидация прошла успешно!");
        } else {
            for (ConstraintViolation<T> violation : violations) {
                System.out.println(violation.getPropertyPath() + " " + violation.getMessage());
            }
        }
    }
}
