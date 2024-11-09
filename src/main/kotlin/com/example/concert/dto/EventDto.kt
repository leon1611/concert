package com.example.concert.dto

import jakarta.validation.constraints.NotNull
import java.time.LocalDate

class EventDto {

    @NotNull(message = "title is required")
    var title: String = ""
    var address: String = ""
    var dayEvent: LocalDate? = null
    var totalAttendees: Int? = null

}
