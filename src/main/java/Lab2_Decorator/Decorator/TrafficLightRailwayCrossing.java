package Lab2_Decorator.Decorator;

import Lab2_Decorator.Abstraction.IRailwayCrossingDescription;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
@NoArgsConstructor
@AllArgsConstructor
public class TrafficLightRailwayCrossing implements IRailwayCrossingDescription  {

    private String additionalInfrastructure = " + Светофор";

    @Inject
    @Delegate
    private IRailwayCrossingDescription railwayCrossingDescription;


    @Override
    public String getDescription() {
        String baseInfrastructure = railwayCrossingDescription.getDescription();

        return baseInfrastructure + additionalInfrastructure;
    }
}
