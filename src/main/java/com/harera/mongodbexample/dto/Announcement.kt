package com.harera.mongodbexample.dto

data class Announcement(
    val announcementId: Int,
    val announcementTitle: String,
    val announcementDescription: String?,
    val announcementImageUrl: String,
    val startDate: String,
    val endDate: String,
)