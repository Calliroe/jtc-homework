package aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("aop");
        PrintService printService = context.getBean(PrintService.class);
        printService.print("Hey");
    }
}
