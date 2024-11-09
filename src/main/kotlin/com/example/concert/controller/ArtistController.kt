package com.example.concert.controller

import com.example.concert.dto.ArtistDto
import com.example.concert.entity.Artist
import com.example.concert.response.ErrorResponse
import com.example.concert.response.SuccessResponse
import com.example.concert.service.ArtistService
import jakarta.persistence.EntityNotFoundException
import jakarta.validation.Valid
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/artists")
class ArtistController {

    @Autowired
    lateinit var artistService: ArtistService

    @GetMapping()
    fun getArtist():ResponseEntity<Any>{
    return try {
        val artist = artistService.getArtist()
        ResponseEntity(SuccessResponse(data = artist), HttpStatus.OK)
    } catch (e: Exception) {
        ResponseEntity(ErrorResponse(message = "Error al obterner a los artistas", code = 500), HttpStatus.INTERNAL_SERVER_ERROR)
    }
    }


    @PostMapping
    fun save(@RequestBody @Valid artistDto: ArtistDto): Artist{
        return artistService.save(artistDto)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            artistService.delete(id)
            ResponseEntity.noContent().header("El Artista ha sido eliminado").build() // Respuesta HTTP 204 No Content si se eliminó correctamente
        } catch (e: EntityNotFoundException) {
            ResponseEntity.notFound().build() // Respuesta HTTP 404 si no se encuentra el artista
        }
    }



}
