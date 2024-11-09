package com.example.concert.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "event")
class Event {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var title: String? = null
    var address: String? = null
    var dayEvent: LocalDate? = null
    var totalAttendees: Int? = null



    }
