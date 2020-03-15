package myapp.imp;

import myapp.services.ICalculator;
import myapp.services.ILogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class DecoratorCalculator implements ICalculator {

    ICalculator calculator;
    ILogger logger;

    public DecoratorCalculator(ICalculator calculator, ILogger logger) {
        this.calculator = calculator;
        this.logger = logger;
    }

    @Override
    public int add(int a, int b) {
        logger.log("Voila le résultat");
        return calculator.add(a, b);
    }
}
