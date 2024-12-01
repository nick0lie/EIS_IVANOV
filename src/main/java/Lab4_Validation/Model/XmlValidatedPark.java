package Lab4_Validation.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class XmlValidatedPark {
    private String name;
    private String address;
    private int numberOfTrees;
    private String parkType;
}
