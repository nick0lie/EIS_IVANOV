package Lab1_CDI.Calculator;

import Lab1_CDI.Annotation.MINORS_METHOD;

@MINORS_METHOD
public class RankByMinorsMethod implements IMatrixRankCalculator {

    @Override
    public int calculateRank(double[][] matrix) {
        System.out.println("Вычисление ранга матрицы методом окаймляющих миноров...");
        return calculate(matrix);
    }

    private int calculate(double[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int rank = Math.min(rows, cols);

        while (rank > 0) {
            if (hasNonZeroMinor(matrix, rank)) {
                return rank;
            }
            rank--;
        }
        return 0;
    }

    private boolean hasNonZeroMinor(double[][] matrix, int size) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i <= rows - size; i++) {
            for (int j = 0; j <= cols - size; j++) {
                if (calculateDeterminant(subMatrix(matrix, i, j, size)) != 0) {
                    return true;
                }
            }
        }
        return false;
    }

    private double[][] subMatrix(double[][] matrix, int rowStart, int colStart, int size) {
        double[][] subMatrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                subMatrix[i][j] = matrix[rowStart + i][colStart + j];
            }
        }
        return subMatrix;
    }

    private double calculateDeterminant(double[][] matrix) {
        int n = matrix.length;
        if (n == 1) {
            return matrix[0][0];
        }
        if (n == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        double determinant = 0;
        for (int i = 0; i < n; i++) {
            determinant += Math.pow(-1, i) * matrix[0][i] * calculateDeterminant(minor(matrix, 0, i));
        }
        return determinant;
    }

    private double[][] minor(double[][] matrix, int row, int col) {
        int n = matrix.length;
        double[][] minor = new double[n - 1][n - 1];
        int r = 0;
        for (int i = 0; i < n; i++) {
            if (i == row) continue;
            int c = 0;
            for (int j = 0; j < n; j++) {
                if (j == col) continue;
                minor[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return minor;
    }
}
