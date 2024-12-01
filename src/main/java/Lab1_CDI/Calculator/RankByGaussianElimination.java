package Lab1_CDI.Calculator;

import Lab1_CDI.Annotation.GAUSSIAN_METHOD;

@GAUSSIAN_METHOD
public class RankByGaussianElimination implements IMatrixRankCalculator {

    @Override
    public int calculateRank(double[][] matrix) {
        System.out.println("Вычисление ранга матрицы методом Гаусса...");
        return calculate(matrix);
    }

    private int calculate(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rank = cols;

        for (int row = 0; row < rank; row++) {
            if (matrix[row][row] != 0) {
                for (int col = 0; col < rows; col++) {
                    if (col != row) {
                        double ratio = matrix[col][row] / matrix[row][row];
                        for (int i = 0; i < rank; i++) {
                            matrix[col][i] -= ratio * matrix[row][i];
                        }
                    }
                }
            } else {
                boolean reduce = true;
                for (int i = row + 1; i < rows; i++) {
                    if (matrix[i][row] != 0) {
                        double[] temp = matrix[row];
                        matrix[row] = matrix[i];
                        matrix[i] = temp;
                        reduce = false;
                        break;
                    }
                }
                if (reduce) {
                    rank--;
                    for (int i = 0; i < rows; i++) {
                        matrix[i][row] = matrix[i][rank];
                    }
                }
                row--;
            }
        }
        return rank;
    }
}
