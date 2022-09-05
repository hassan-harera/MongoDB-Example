package com.harera.mongodbexample.mapper

import com.harera.mongodbexample.entity.AnnouncementEntity
import com.harera.mongodbexample.request.PostAnnouncementRequest
import java.text.SimpleDateFormat

object AnnouncementRequestMapper {

    fun toAnnouncementEntity(request: PostAnnouncementRequest): AnnouncementEntity {
        return AnnouncementEntity(
            request.startDate.let { SimpleDateFormat().parse(it) },
            request.endDate.let { SimpleDateFormat().parse(it) },
            request.announcementDescription,
            request.announcementImageUrl,
            request.announcementTitle,
        )
    }
}