package com.alx.cinebook

import com.fasterxml.jackson.annotation.JsonProperty

data class ClientDTOResponse(
    
    @JsonProperty("id")
    var id: Long,
    
    @JsonProperty("name")
    var name: String
    
)
