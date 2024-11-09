package com.example.concert.mapper

import com.example.concert.dto.ArtistDto
import com.example.concert.entity.Artist
import org.apache.coyote.http11.Constants.a

object ArtistMapper {

    fun toEntity(artistDto: ArtistDto): Artist {
        val artist = Artist()
        artist.name = artistDto.name
        artist.country=artistDto.country
        artist.email=artistDto.email
        artist.phone=artistDto.phone

        return artist
    }

}