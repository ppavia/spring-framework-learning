package ppa.spring.logger;

import org.apache.logging.log4j.Logger;
import org.springframework.core.env.Environment;

public class LoggerTools {
    private LoggerTools() {
    }

    ;

    public static void logEnv(Logger logger, Environment environment) {
        logger.debug("name : {} - env : {}",
                () -> environment.getProperty("spring.application.name"),
                () -> environment.getProperty("spring.profiles.active"));
    }
}
