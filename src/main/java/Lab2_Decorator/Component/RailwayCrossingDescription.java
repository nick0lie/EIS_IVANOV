package Lab2_Decorator.Component;


import Lab2_Decorator.Abstraction.IRailwayCrossingDescription;

import javax.inject.Inject;

public class RailwayCrossingDescription {

    @Inject
    private IRailwayCrossingDescription railwayCrossingDescription;

    public String getDescription() {
        return railwayCrossingDescription.getDescription();
    }

}
