package myapp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import myapp.imp.DecoratorCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import myapp.imp.StderrLogger;
import myapp.services.ICalculator;
import myapp.services.ILogger;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppConfig.class)
public class TestAppConfigJunit {

    @Autowired
    ApplicationContext context;

    @Autowired
    StderrLogger stderrLogger;

    @Autowired
    ICalculator calculator;

    @Test
    public void testStderrLogger() {
        stderrLogger.log("hello on stderr");
    }

    @Autowired
    @Qualifier("file")
    ILogger fileLogger;

    @Test
    public void testFileLogger() {
        fileLogger.log("hello on file");
    }

    @Test
    public void testCalculator() {
        assertEquals(30, calculator.add(10, 20));
    }

    @Test
    public void testDecoratorCalculator() {
        new DecoratorCalculator(calculator, fileLogger).add(10, 20);
    }

}