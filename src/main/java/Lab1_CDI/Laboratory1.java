package Lab1_CDI;

import Lab1_CDI.Component.MatrixRankCalculator;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Laboratory1 {
    protected static Weld weld;
    protected static WeldContainer container;

    public static void main(String[] args) {
        weld = new Weld();
        container = weld.initialize();

        try {
            MatrixRankCalculator rankCalculator = container.select(MatrixRankCalculator.class).get();

            double[][] matrix = {
                    {1, 2, 3},
                    {4, 5, 6},
                    {7, 8, 9}
            };

            int rank = rankCalculator.calculateRank(matrix);
            System.out.println("Ранг матрицы: " + rank);

        } finally {
            weld.shutdown();
        }
    }
}
