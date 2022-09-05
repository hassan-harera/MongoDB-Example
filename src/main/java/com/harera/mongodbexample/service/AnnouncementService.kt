package com.harera.mongodbexample.service

import com.harera.mongodbexample.mapper.AnnouncementEntityMapper
import com.harera.mongodbexample.dto.Announcement
import com.harera.mongodbexample.mapper.AnnouncementRequestMapper
import com.harera.mongodbexample.repository.AnnouncementRepository
import com.harera.mongodbexample.request.PostAnnouncementRequest
import com.harera.mongodbexample.utils.AnnouncementState
import org.springframework.stereotype.Service

interface AnnouncementService {
    fun getAnnouncements(announcementState: String): Result<List<Announcement>>
    fun getAnnouncement(announcementId: Int): Result<Announcement>
    fun saveAnnouncement(request: PostAnnouncementRequest): Result<Announcement>
}

@Service
class AnnouncementServiceImpl(
    private val announcementEntityRepository: AnnouncementRepository
) : AnnouncementService {

    override fun getAnnouncements(announcementState: String): Result<List<Announcement>> = kotlin.runCatching {
        when(announcementState) {
            AnnouncementState.ALL -> getAllAnnouncements()
            AnnouncementState.ACTIVE -> getActiveAnnouncements()
            AnnouncementState.INACTIVE -> getInactiveAnnouncements()
            else -> throw IllegalArgumentException("Unknown announcement state: $announcementState")
        }
    }

    override fun getAnnouncement(announcementId: Int): Result<Announcement> = kotlin.runCatching {
            announcementEntityRepository
                .getAnnouncementsByAnnouncementId(announcementId)
                .get()
                .let {
                    AnnouncementEntityMapper.toAnnouncement(it)
                }
    }

    override fun saveAnnouncement(request: PostAnnouncementRequest): Result<Announcement> = kotlin.runCatching {
        announcementEntityRepository
            .save(AnnouncementRequestMapper.toAnnouncementEntity(request))
            .let {
                AnnouncementEntityMapper.toAnnouncement(it)
            }
    }

    private fun getInactiveAnnouncements(): List<Announcement> {
        return announcementEntityRepository.getAnnouncementsByAnnouncementState(0).map { AnnouncementEntityMapper.toAnnouncement(it) }
    }

    private fun getActiveAnnouncements(): List<Announcement> {
        return announcementEntityRepository.getAnnouncementsByAnnouncementState(1).map { AnnouncementEntityMapper.toAnnouncement(it) }
    }

    private fun getAllAnnouncements(): List<Announcement> {
        return announcementEntityRepository.findAll().map { AnnouncementEntityMapper.toAnnouncement(it) }
    }
}


