package com.mag.studycase.logging;

public interface LoggingService {

    public void addLog(String endpoint, String object);

    void addLogGetAllSubscriber();

    void addLogGetSubscriber(String id);

}
