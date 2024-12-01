package Lab2_Decorator.Component;

import Lab2_Decorator.Abstraction.IRailwayCrossingDescription;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.enterprise.inject.Default;

@Default
@AllArgsConstructor
public class SimpleRailwayCrossing implements IRailwayCrossingDescription {

    @Override
    public String getDescription() {
        return "Простой нерегулируемый железнодорожный переезд";
    }
}
