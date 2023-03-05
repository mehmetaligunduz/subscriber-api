package com.mag.studycase.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Subscriber id already exist")
public class SubscriberIdAlreadyExistException extends RuntimeException {

    public SubscriberIdAlreadyExistException() {
        super("Subscriber id already exist");
    }
}
