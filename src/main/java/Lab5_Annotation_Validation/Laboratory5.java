package Lab5_Annotation_Validation;

import Lab5_Annotation_Validation.Model.Park;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ParameterMessageInterpolator;

public class Laboratory5 {

    public static void main(String[] args) {
        // Создаем экземпляры парков
        Park validPark1 = new Park(1, 0); // Валидный
        Park validPark2 = new Park(0, 1); // Валидный
        Park invalidPark = new Park(0, 0); // Невалидный

        ValidatorFactory factory = Validation.byDefaultProvider()
                .configure()
                .messageInterpolator(new ParameterMessageInterpolator())
                .buildValidatorFactory();
        Validator validator = factory.getValidator();

        // Проверяем валидный парк с транзитным приоритетом
        System.out.println("Valid Park 1:");
        validator.validate(validPark1).forEach(violation -> System.out.println(violation.getMessage()));

        // Проверяем валидный парк с приоритетом на расформирование
        System.out.println("\nValid Park 2:");
        validator.validate(validPark2).forEach(violation -> System.out.println(violation.getMessage()));

        // Проверяем невалидный парк
        System.out.println("\nInvalid Park:");
        validator.validate(invalidPark).forEach(violation -> System.out.println(violation.getMessage()));
    }
}
