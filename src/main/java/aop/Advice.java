package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class Advice implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        int count = methodInvocation.getMethod().getAnnotation(Times.class).count();
        if (count <= 0) return null;
        Object object = methodInvocation.proceed();
        for (int i = 0; i < count - 1; i++) {
            methodInvocation.proceed();
        }
        return object;
    }
}