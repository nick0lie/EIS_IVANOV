package Lab1_CDI.Component;

import Lab1_CDI.Annotation.BY_DEFINITION;
import Lab1_CDI.Annotation.GAUSSIAN_METHOD;
import Lab1_CDI.Annotation.MINORS_METHOD;
import Lab1_CDI.Calculator.IMatrixRankCalculator;
import Lab1_CDI.Interceptor.ProfileInterceptor;
import lombok.NoArgsConstructor;

import javax.inject.Inject;
import javax.interceptor.Interceptors;

@Interceptors(ProfileInterceptor.class)
@NoArgsConstructor
public class MatrixRankCalculator {

    @Inject
//    @BY_DEFINITION
//     @MINORS_METHOD
     @GAUSSIAN_METHOD
    private IMatrixRankCalculator calculator;

    public int calculateRank(double[][] matrix) {
        return calculator.calculateRank(matrix);
    }
}
