package myapp.test;

import myapp.imp.BeanFileLogger;
import myapp.imp.FileLogger;
import myapp.imp.SimpleCalculator;
import myapp.imp.StderrLogger;
import myapp.services.ICalculator;
import myapp.services.ILogger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLoggerServices {

    @BeforeEach
    public void beforeEachTest() {
        System.err.println("====================");
    }

    @AfterEach
    public void afterEachTest() {
    }

    // use a logger
    void use(ILogger logger) {
        logger.log("Voila le résultat = hello");
    }

    // Test StderrLogger
    @Test
    public void testStderrLogger() {
        // create the service
        var logger = new StderrLogger();
        // start the service
        logger.start();
        // use the service
        use(logger);
        // stop the service
        logger.stop();
    }

    @Test
    public void testFileLogger() {
        var logger = new FileLogger("/tmp/myapp.log");
        logger.start();
        use(logger);
        logger.stop();
    }

    @Test
    public void testBeanFileLogger() {
        // create the service
        var logger = new BeanFileLogger();
        // set parameter
        logger.setFileName("/tmp/myapp.log");
        // start
        logger.start();
        // use
        use(logger);
        // stop
        logger.stop();
    }

    void use(ICalculator calc) {
        assertEquals(300, calc.add(100, 200));
    }

    @Test
    public void testCalculorAndStderrLogger() {
        // create and start the logger service (on stderr)
        var logger = new BeanFileLogger();
        logger.setFileName("/tmp/myapp.log");
        logger.start();
        // create, inject and start the calculator service
        var calculator = new SimpleCalculator();
        calculator.setLogger(logger);
        calculator.start();
        // use the calculator service
        use(calculator);
        // stop the calculator service
        calculator.stop();
        // stop the logger service
        logger.stop();
    }

}