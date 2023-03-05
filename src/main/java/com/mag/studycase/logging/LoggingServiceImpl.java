package com.mag.studycase.logging;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class LoggingServiceImpl implements LoggingService {

    private final Logger logger;

    @Override
    public void addLog(String endpoint, String object) {
        String message = String.format("%s %s %s", getCurrentDateTime(), endpoint, object);
        logger.info(message);
    }

    @Override
    public void addLogGetAllSubscriber() {
        String message = String.format("%s /getAllSubscribers", getCurrentDateTime());
        logger.info(message);
    }

    @Override
    public void addLogGetSubscriber(String id) {
        String message = String.format("%s /getSubscriberById is = %s", getCurrentDateTime(), id);
        logger.info(message);
    }

    private String getCurrentDateTime() {
        return LocalDateTime
                .now()
                .format(DateTimeFormatter
                        .ofPattern("dd-MM-yyyy HH:mm:ss"));
    }

}
