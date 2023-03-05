package com.mag.studycase.service;

import com.mag.studycase.model.request.AddSubscriberRequest;
import com.mag.studycase.model.request.DeleteSubscriberRequest;
import com.mag.studycase.model.request.UpdateSubscriberRequest;
import com.mag.studycase.model.response.AddSubscriberResponse;
import com.mag.studycase.model.response.UpdateSubscriberResponse;
import com.mag.studycase.model.soap.SubscriberListResponse;

public interface SubscriberService {

    AddSubscriberResponse addSubscriber(AddSubscriberRequest request);

    UpdateSubscriberResponse updateSubscriber(UpdateSubscriberRequest request);

    void deleteSubscriber(DeleteSubscriberRequest request);

    SubscriberListResponse getAllSubscribers();

}
