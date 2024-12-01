package Lab3_Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Automobile {
    private Integer id;
    private String mark;
    private String model;
    private AutomobileStatus status;
}
