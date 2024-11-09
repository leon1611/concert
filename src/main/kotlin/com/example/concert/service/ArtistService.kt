package com.example.concert.service

import com.example.concert.dto.ArtistDto
import com.example.concert.entity.Artist
import com.example.concert.mapper.ArtistMapper
import com.example.concert.repository.ArtistRepository
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ArtistService {

    @Autowired
    private lateinit var artistRepository: ArtistRepository

    fun getArtist ():List<Artist>{
        return artistRepository.findAll()
    }
fun save(artistDto: ArtistDto): Artist{
    val artist: Artist = ArtistMapper.toEntity(artistDto)
    return artistRepository.save(artist)
}


    fun deleted(id: Long) {
        val artist = artistRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Artist not found with id $id") }
        artistRepository.delete(artist)
    }

    fun delete(id: Long) {
        // Buscar al artista por su ID
        val artist = artistRepository.findById(id)
            .orElseThrow { EntityNotFoundException("Artist not found with id $id") }

        // Eliminar al artista
        artistRepository.delete(artist)
    }

}
