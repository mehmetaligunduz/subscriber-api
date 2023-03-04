package com.mag.studycase.services;

import com.mag.studycase.entity.SubscriberEntity;
import com.mag.studycase.model.request.AddSubscriberRequest;
import com.mag.studycase.model.request.DeleteSubscriberRequest;
import com.mag.studycase.model.request.UpdateSubscriberRequest;
import com.mag.studycase.model.response.AddSubscriberResponse;
import com.mag.studycase.model.response.UpdateSubscriberResponse;

public interface SubscriberService {

    AddSubscriberResponse addSubscriber(AddSubscriberRequest request);

    UpdateSubscriberResponse updateSubscriber(UpdateSubscriberRequest request);

    void deleteSubscriber(DeleteSubscriberRequest request);

    SubscriberEntity getSubscriber(String subscriberId);

}
