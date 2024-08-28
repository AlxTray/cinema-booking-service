package com.alx.cinebook

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "client")
data class ClientEntity (
    
    @Id
    @GeneratedValue
    var id: Long?,
    var name: String

)