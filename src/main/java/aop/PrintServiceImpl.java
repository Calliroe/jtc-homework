package aop;

import org.springframework.stereotype.Component;

@Component
public class PrintServiceImpl implements PrintService {
    @Override
    @Times(count = 3)
    public void print(String name) {
        System.out.println(name);
    }
}
