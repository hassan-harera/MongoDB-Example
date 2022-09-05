package com.harera.mongodbexample.request

import org.springframework.format.annotation.DateTimeFormat
import javax.validation.constraints.NotBlank

data class PostAnnouncementRequest(
    @NotBlank
    val announcementTitle: String,
    val announcementDescription: String?,
    @NotBlank
    val announcementImageUrl: String,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val startDate: String,
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    val endDate: String,
)
