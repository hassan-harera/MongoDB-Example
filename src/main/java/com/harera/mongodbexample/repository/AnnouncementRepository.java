package com.harera.mongodbexample.repository;

import com.harera.mongodbexample.entity.AnnouncementEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface AnnouncementRepository extends MongoRepository<AnnouncementEntity, Integer> {
    List<AnnouncementEntity> getAnnouncementsByAnnouncementState(Integer state);

    Optional<AnnouncementEntity> getAnnouncementsByAnnouncementId(Integer announcementId);
}