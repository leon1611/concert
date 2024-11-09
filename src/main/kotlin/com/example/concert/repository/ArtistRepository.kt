package com.example.concert.repository

import com.example.concert.entity.Artist
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ArtistRepository: JpaRepository<Artist, Long> {
}