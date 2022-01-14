package aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;

public class Main {
    public static void main(String[] args) {
        PrintService printService = new PrintServiceImpl();
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(Times.class);
        Advisor advisor = new DefaultPointcutAdvisor(pointcut, new Advice());
        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(printService);
        pf.addAdvisor(advisor);
        PrintService proxy = (PrintService) pf.getProxy();
        proxy.print("Hey");
    }
}
