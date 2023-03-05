package com.mag.studycase.cache;

import com.mag.studycase.entity.SubscriberEntity;
import com.mag.studycase.entity.SubscriberListEntity;

import java.util.List;

public interface CacheService {

    void put(SubscriberEntity subscriber);

    SubscriberEntity update(SubscriberEntity subscriber);

    void delete(String subscriberId);

    void init(List<SubscriberEntity> list);

     SubscriberListEntity getAll();

}
