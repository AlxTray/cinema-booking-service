package com.alx.cinebook.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MoviesRepository : JpaRepository<MoviesEntity, Long>