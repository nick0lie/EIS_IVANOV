package Lab4_Validation.Model;

import jakarta.validation.constraints.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CodeValidatedPark {

    @NotNull(message = "Название парка не должно быть пустым")
    @Pattern(regexp = "^[A-Za-zА-Яа-яЁё\\s]+$", message = "Название парка должно содержать только буквы и пробелы")
    private String name;

    @NotNull(message = "Адрес не должен быть пустым")
    private String address;

    @Min(value = 1, message = "Минимальное количество деревьев должно быть 1")
    @Max(value = 10000, message = "Максимальное количество деревьев — 10,000")
    private int numberOfTrees;

    @NotNull(message = "Тип парка не должен быть пустым")
    @Pattern(regexp = "^(Национальный|Городской|Природный)$", message = "Тип парка должен быть: Национальный, Городской или Природный")
    private String parkType;
}
