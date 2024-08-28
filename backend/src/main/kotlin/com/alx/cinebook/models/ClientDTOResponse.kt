package com.alx.cinebook.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ClientDTOResponse(
    
    @JsonProperty("id")
    var id: Long,
    
    @JsonProperty("name")
    var name: String
    
)
