package myapp.imp;

import myapp.services.ICalculator;
import org.springframework.stereotype.Service;

@Service("calculator")
public class Calculator implements ICalculator {

    @Override
    public int add(int a, int b) {
        return (a + b);
    }
}
