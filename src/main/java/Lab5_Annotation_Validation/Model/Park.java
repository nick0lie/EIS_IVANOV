package Lab5_Annotation_Validation.Model;

import Lab5_Annotation_Validation.Annotation.ValidParkPriority;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ValidParkPriority
public class Park {

    @NotNull(message = "Приоритет приёма транзитного поезда не должен быть null")
    private Integer transitTrainPriority;

    @NotNull(message = "Приоритет приёма поезда в расформирование не должен быть null")
    private Integer disbandTrainPriority;
}
