package Lab1_CDI.Interceptor;

import lombok.NoArgsConstructor;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

@NoArgsConstructor
public class ProfileInterceptor {

    @AroundInvoke
    public Object profileExecution(InvocationContext context) throws Exception {
        long startTime = System.nanoTime();
        try {
            return context.proceed();
        } finally {
            long endTime = System.nanoTime();
            System.out.println("Время выполнения: " + (endTime - startTime) + " нс");
        }
    }
}
