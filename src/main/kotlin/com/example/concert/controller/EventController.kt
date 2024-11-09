package com.example.concert.controller

import com.example.concert.dto.EventDto
import com.example.concert.entity.Event
import com.example.concert.repository.EventRepository
import com.example.concert.response.ErrorResponse
import com.example.concert.response.SuccessResponse
import com.example.concert.service.EventService
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.domain.AbstractPersistable_.id
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/events")
class EventController {

    @Autowired
    lateinit var eventService: EventService

    @GetMapping
    fun getEvents(): ResponseEntity<Any> {
        return try {
            val event =eventService.getEvents()
            ResponseEntity(SuccessResponse(data = event), HttpStatus.OK)
        } catch (e:Exception){
            ResponseEntity(ErrorResponse(message = "Error al obtener los eventos", code = 500), HttpStatus.INTERNAL_SERVER_ERROR)
        }
    }


    @PostMapping
    fun save(@RequestBody @Valid eventDto: EventDto):Event{
        return eventService.save(eventDto)

        }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            eventService.delete(id)
            ResponseEntity.noContent().header("EL evento ha sido eliminado").build() // Respuesta HTTP 204 No Content si se eliminó correctamente
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build() // Respuesta HTTP 404 si no se encuentra el evento
        }
    }


}
















