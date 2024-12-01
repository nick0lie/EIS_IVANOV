package Lab1_CDI.Calculator;

import Lab1_CDI.Annotation.BY_DEFINITION;

@BY_DEFINITION
public class RankByDefinition implements IMatrixRankCalculator {

    @Override
    public int calculateRank(double[][] matrix) {
        System.out.println("Вычисление ранга матрицы по определению...");
        return calculate(matrix);
    }

    private int calculate(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rank = Math.min(rows, cols);

        for (int i = 0; i < rank; i++) {
            if (matrix[i][i] != 0) {
                for (int j = 0; j < rows; j++) {
                    if (j != i) {
                        double ratio = matrix[j][i] / matrix[i][i];
                        for (int k = 0; k < cols; k++) {
                            matrix[j][k] -= ratio * matrix[i][k];
                        }
                    }
                }
            } else {
                boolean reduce = true;
                for (int j = i + 1; j < rows; j++) {
                    if (matrix[j][i] != 0) {
                        double[] temp = matrix[i];
                        matrix[i] = matrix[j];
                        matrix[j] = temp;
                        reduce = false;
                        break;
                    }
                }
                if (reduce) {
                    rank--;
                    for (int j = 0; j < rows; j++) {
                        matrix[j][i] = matrix[j][rank];
                    }
                }
                i--;
            }
        }
        return rank;
    }
}
