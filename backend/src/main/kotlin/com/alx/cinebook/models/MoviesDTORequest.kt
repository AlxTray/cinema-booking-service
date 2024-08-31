package com.alx.cinebook.models

import com.fasterxml.jackson.annotation.JsonProperty

data class MoviesDTORequest(
    
    @JsonProperty("name")
    var name: String
    
)
