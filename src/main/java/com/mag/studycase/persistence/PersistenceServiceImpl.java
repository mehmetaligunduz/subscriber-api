package com.mag.studycase.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mag.studycase.cache.CacheService;
import com.mag.studycase.entity.SubscriberListEntity;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersistenceServiceImpl implements PersistenceService {

    private final ObjectMapper objectMapper;

    private final CacheService cacheService;

    private final File file;

    @PostConstruct
    @Override
    public void initializeCache() {
        try {

            if (!file.exists()) {
                return;
            }

            if (file.length() == 0) {
                return;
            }

            final SubscriberListEntity subscriberListEntity = objectMapper.readValue(file, SubscriberListEntity.class);

            cacheService.init(subscriberListEntity.getSubscribers());

            log.info("Cache initialization completed successfully");

        } catch (IOException e) {

            throw new RuntimeException(e);

        }
    }

    @Scheduled(cron = "${schedule.cron}")
    @PreDestroy
    @Override
    public void storeCache() {
        try {

            SubscriberListEntity cache = cacheService.getAll();
            objectMapper.writeValue(file, cache);

            log.info("Cache storing completed successfully");

        } catch (Exception e) {

            throw new RuntimeException(e);

        }

    }

}
