package com.example.concert.service

import com.example.concert.dto.EventDto
import com.example.concert.entity.Event
import com.example.concert.mapper.EventMapper
import com.example.concert.repository.EventRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class EventService {
    @Autowired
    private lateinit var eventRepository: EventRepository

    fun getEvents(): List<Event> {
        return eventRepository.findAll()
    }


    fun save( eventDto: EventDto): Event {
        val event : Event = EventMapper.toEntity(eventDto)
        return eventRepository.save(event)

    }

    fun delete(id: Long) {
        // Verifica si el evento existe
        val event = eventRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Event not found with id $id") }

        // Si el evento existe, se elimina
        eventRepository.delete(event)
    }


}