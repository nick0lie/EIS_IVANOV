package Lab2_Decorator;

import Lab2_Decorator.Component.RailwayCrossingDescription;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory2 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {

            RailwayCrossingDescription railwayCrossingDescription = container.select(RailwayCrossingDescription.class).get();

            System.out.println(railwayCrossingDescription.getDescription());

        } finally {
            weld.shutdown();
        }
    }
}
