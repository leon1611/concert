package com.example.concert.mapper
import com.example.concert.dto.EventDto
import com.example.concert.entity.Event

object EventMapper {


        fun toEntity(eventDto: EventDto): Event {
            val event = Event()
            event.title = eventDto.title
            event.address = eventDto.address
            event.dayEvent= eventDto.dayEvent
            event.totalAttendees= eventDto.totalAttendees
            return event
            }

}