package com.mag.studycase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Subscriber Not Found")
public class SubscriberNotFoundException extends RuntimeException {

    public SubscriberNotFoundException() {
        super("Subscriber Not Found");
    }

}
