package com.mag.studycase.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class FileConfiguration {

    @Value("${data.data_file_path}")
    private String dataFile;

    @Bean
    public File file() {

        return new File(dataFile);

    }

}
