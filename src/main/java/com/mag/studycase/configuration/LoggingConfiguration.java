package com.mag.studycase.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Configuration
public class LoggingConfiguration {

    private final static String FILE_NAME = "app.log";

    private static final Logger logger = Logger.getLogger("Studycase.Request.Logger");

    @Bean
    public Logger logger() throws IOException {
        FileHandler fileHandler = new FileHandler(FILE_NAME, true);
        logger.addHandler(fileHandler);
        fileHandler.setFormatter(new SimpleFormatter());
        return logger;
    }

}
