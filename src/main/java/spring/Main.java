package spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("spring");
        PrintService printService = (PrintService) context.getBean("printServiceImpl");
        printService.print("YO");
    }
}
