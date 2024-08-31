package com.alx.cinebook.repositories

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "movies")
data class MoviesEntity (
    
    @Id
    @GeneratedValue
    var id: Long?,
    var name: String

)