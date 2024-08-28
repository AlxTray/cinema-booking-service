package com.alx.cinebook.models

import com.fasterxml.jackson.annotation.JsonProperty

data class ClientDTORequest(
    
    @JsonProperty("name")
    var name: String
    
)
