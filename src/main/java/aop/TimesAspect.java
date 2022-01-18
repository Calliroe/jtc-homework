package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class TimesAspect {

    @Pointcut("@annotation(aop.Times)")
    public void methodWithTimes() {
    }

    @Around("methodWithTimes()")
    public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = joinPoint.getTarget().getClass().getDeclaredMethod(signature.getMethod().getName(), signature.getMethod().getParameterTypes());
        Times annotation = method.getAnnotation(Times.class);
        int count = annotation.count();
        if (count <= 0) {
            return null;
        }
        Object object = joinPoint.proceed();
        for (int i = 0; i < count - 1; i++) {
            joinPoint.proceed();
        }
        return object;
    }
}
