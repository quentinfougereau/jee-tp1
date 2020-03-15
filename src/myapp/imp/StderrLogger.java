package myapp.imp;

import myapp.services.ILogger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service("stderrLogger")
@Qualifier("test")
public class StderrLogger implements ILogger {

    public void start() {
        System.err.println("Start " + this);
    }

    public void stop() {
        System.err.println("Stop " + this);
    }

    @Override
    public void log(String message) {
        System.err.printf("%tF %1$tR | %s\n", new Date(), message);
    }

}
