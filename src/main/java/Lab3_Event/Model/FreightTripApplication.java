package Lab3_Event.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FreightTripApplication {
    private Driver driver;
    private Automobile automobile;
    private FreightTripStatus status;
}
