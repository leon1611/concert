package com.example.concert.dto

import jakarta.validation.constraints.NotNull

class ArtistDto {
    @NotNull (message = "Name is required")
    var name: String = ""
    var country: String = ""
    var email: String? = ""
    var phone: String? = ""


}