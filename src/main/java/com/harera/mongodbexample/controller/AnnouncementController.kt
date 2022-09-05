package com.harera.mongodbexample.controller

import com.harera.mongodbexample.request.PostAnnouncementRequest
import com.harera.mongodbexample.utils.AnnouncementState
import com.harera.mongodbexample.utils.Parameter
import com.harera.mongodbexample.service.AnnouncementService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/announcement")
class AnnouncementController(
    private val announcementService: AnnouncementService
) {

    @GetMapping("/all")
    fun getAnnouncements(
        @RequestParam(Parameter.ANNOUNCEMENT_STATE, defaultValue = AnnouncementState.ACTIVE) offerState: String
    ): ResponseEntity<Any> {
        announcementService
            .getAnnouncements(offerState)
            .getOrElse {
                return ResponseEntity.badRequest().body(it.message)
            }
            .let {
                return ResponseEntity.ok(it)
            }
    }

    @GetMapping("/{${Parameter.ANNOUNCEMENT_ID}}")
    fun getAnnouncement(
        @PathVariable(value = Parameter.ANNOUNCEMENT_ID, required = true) announcementId: Int
    ): ResponseEntity<Any> {
        announcementService
            .getAnnouncement(announcementId)
            .getOrElse {
                return ResponseEntity.badRequest().body(it.message)
            }
            .let {
                return ResponseEntity.ok(it)
            }
    }


    @PostMapping
    fun postAnnouncement(
        @RequestBody request: PostAnnouncementRequest
    ): ResponseEntity<Any> {
        announcementService
            .saveAnnouncement(request)
            .getOrElse {
                return ResponseEntity.badRequest().body(it.message)
            }
            .let {
                return ResponseEntity.ok(it)
            }
    }
}