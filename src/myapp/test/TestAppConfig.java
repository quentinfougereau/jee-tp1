package myapp.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import myapp.imp.StderrLogger;
import myapp.services.ILogger;

public class TestAppConfig {

    /*
     * Construction d'un contexte classique
     */
    @Test
    public void testStderrLogger() {
        try (var c = new AnnotationConfigApplicationContext(AppConfig.class)) {
            var logger = c.getBean(StderrLogger.class);
            logger.log("hello on stderr");
        }
    }

}