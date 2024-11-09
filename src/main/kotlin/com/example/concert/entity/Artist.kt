package com.example.concert.entity

import jakarta.persistence.*


@Entity
@Table(name = "artist")
class Artist {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null

    var name: String? = null
    var country: String? = null
    var email: String? = null
    var phone: String? = null



}