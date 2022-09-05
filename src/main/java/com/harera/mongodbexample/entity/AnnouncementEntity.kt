package com.harera.mongodbexample.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "Announcement")
class AnnouncementEntity {
    @Id
    val announcementId: Int = 0
    val announcementState: Int = 1
    lateinit var announcementEndDate: Date
    lateinit var announcementStartDate: Date
    var announcementDetail: String? =null
    lateinit var announcementImageUrl: String
    lateinit var announcementTitle: String


    constructor()

    constructor(
        announcementEndDate: Date,
        announcementStartDate: Date,
        announcementDetail: String?,
        announcementImageUrl: String,
        announcementTitle: String
    ) {
        this.announcementEndDate = announcementEndDate
        this.announcementStartDate = announcementStartDate
        this.announcementDetail = announcementDetail
        this.announcementImageUrl = announcementImageUrl
        this.announcementTitle = announcementTitle
    }
}