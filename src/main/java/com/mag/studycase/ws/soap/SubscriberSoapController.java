package com.mag.studycase.ws.soap;

import com.mag.studycase.model.soap.SubscriberListResponse;
import com.mag.studycase.service.SubscriberService;
import lombok.RequiredArgsConstructor;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
public class SubscriberSoapController {

    private final SubscriberService subscriberService;

    @PayloadRoot(namespace = "http://mag.com/studycase/model/soap", localPart = "SubscribersRequest")
    @ResponsePayload
    public SubscriberListResponse getAllSubscribers() {

        return subscriberService.getAllSubscribers();

    }

}
