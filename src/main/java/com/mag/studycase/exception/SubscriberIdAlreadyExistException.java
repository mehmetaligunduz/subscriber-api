package com.mag.studycase.exception;

public class SubscriberIdAlreadyExistException extends RuntimeException {

    public SubscriberIdAlreadyExistException() {
        super("Subscriber id already exist");
    }
}
