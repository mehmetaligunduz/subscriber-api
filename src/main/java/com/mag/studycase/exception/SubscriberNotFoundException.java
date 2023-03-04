package com.mag.studycase.exception;

public class SubscriberNotFoundException extends RuntimeException {

    public SubscriberNotFoundException() {
        super("Subscriber Not Found");
    }
}
