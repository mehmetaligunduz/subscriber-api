package com.mag.studycase.services;

import com.mag.studycase.cache.CacheService;
import com.mag.studycase.entity.SubscriberEntity;
import com.mag.studycase.logging.LoggingService;
import com.mag.studycase.model.request.AddSubscriberRequest;
import com.mag.studycase.model.request.DeleteSubscriberRequest;
import com.mag.studycase.model.request.UpdateSubscriberRequest;
import com.mag.studycase.model.response.AddSubscriberResponse;
import com.mag.studycase.model.response.UpdateSubscriberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SubscriberServiceImpl implements SubscriberService {

    private final CacheService cacheService;

    private final LoggingService loggingService;

    @Override
    public AddSubscriberResponse addSubscriber(AddSubscriberRequest request) {

        loggingService.addLog("/subscriber[POST]", request.toString());

        cacheService.put(request.toEntity());

        return new AddSubscriberResponse(
                request.getId()
        );

    }

    @Override
    public UpdateSubscriberResponse updateSubscriber(UpdateSubscriberRequest request) {

        loggingService.addLog("/subscriber[PUT]", request.toString());

        final SubscriberEntity update = cacheService.update(request.toEntity());

        return new UpdateSubscriberResponse(
                update.getId(),
                update.getName(),
                update.getMsisdn()
        );

    }

    @Override
    public void deleteSubscriber(DeleteSubscriberRequest request) {

        loggingService.addLog("/subscriber[DELETE]", request.toString());
        cacheService.delete(request.getId());

    }

    @Override
    public SubscriberEntity getSubscriber(String subscriberId) {

        return cacheService.getSubscriber(subscriberId);

    }

}
