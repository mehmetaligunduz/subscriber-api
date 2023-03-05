package com.mag.studycase.cache;

import com.mag.studycase.entity.SubscriberEntity;
import com.mag.studycase.entity.SubscriberListEntity;
import com.mag.studycase.exception.SubscriberIdAlreadyExistException;
import com.mag.studycase.exception.SubscriberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.Cache;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;

@Service
@RequiredArgsConstructor
public class CacheServiceImpl implements CacheService {

    private final Cache cache;

    @Override
    public void put(SubscriberEntity subscriber) {

        if (isNotExist(subscriber.getId())) {
            cache.put(subscriber.getId(), subscriber);
            return;
        }

        throw new SubscriberIdAlreadyExistException();
    }

    @Override
    public SubscriberEntity update(SubscriberEntity subscriber) {

        if (isNotExist(subscriber.getId())) {
            throw new SubscriberNotFoundException();
        }

        cache.put(subscriber.getId(), subscriber);
        return subscriber;
    }

    @Override
    public void delete(String subscriberId) {

        if (isNotExist(subscriberId)) {
            throw new SubscriberNotFoundException();
        }

        cache.evict(subscriberId);
    }

    @Override
    public void init(List<SubscriberEntity> list) {

        list.forEach(this::put);

    }

    @Override
    public SubscriberListEntity getAll() {

        ConcurrentMap<Object, Object> nativeCache = (ConcurrentMap<Object, Object>) cache.getNativeCache();
        Set<Object> keys = nativeCache.keySet();

        List<SubscriberEntity> subscriberEntityList = new ArrayList<>();

        keys.forEach(key -> subscriberEntityList
                .add((SubscriberEntity) nativeCache.get(key.toString())));

        SubscriberListEntity subscriberListEntity = new SubscriberListEntity();
        subscriberListEntity.setSubscribers(subscriberEntityList);

        return subscriberListEntity;

    }

    private boolean isNotExist(String id) {

        return Objects.isNull(cache.get(id));

    }

}
