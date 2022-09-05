package com.harera.mongodbexample.mapper

import com.harera.mongodbexample.entity.AnnouncementEntity
import java.time.ZonedDateTime
import com.harera.mongodbexample.dto.Announcement as AnnouncementDto


object AnnouncementEntityMapper {

    fun toAnnouncement(announcementEntity: AnnouncementEntity): AnnouncementDto {
        return AnnouncementDto(
            announcementEntity.announcementId,
            announcementEntity.announcementTitle,
            announcementEntity.announcementDetail,
            announcementEntity.announcementImageUrl,
            announcementEntity.announcementStartDate.let { ZonedDateTime.from(it.toInstant()) }.toString(),
            announcementEntity.announcementEndDate.let { ZonedDateTime.from(it.toInstant()) }.toString(),
        )
    }
}