package myapp.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import myapp.imp.BeanFileLogger;
import myapp.services.ILogger;

@Component
@ComponentScan("myapp.imp")
public class AppConfig {

    @Bean
    @Qualifier("file")
    public ILogger myLogger() {
        var logger = new BeanFileLogger();
        logger.setFileName("/tmp/essai.log");
        System.err.println("Production de " + logger);
        return logger;
    }

}