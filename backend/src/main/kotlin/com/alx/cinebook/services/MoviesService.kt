package com.alx.cinebook.services

import com.alx.cinebook.repositories.MoviesEntity
import com.alx.cinebook.repositories.MoviesRepository
import com.alx.cinebook.models.MoviesDTORequest
import com.alx.cinebook.models.MoviesDTOResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import kotlin.jvm.optionals.getOrNull

@Service
class MoviesService(var moviesRepository: MoviesRepository) {

    fun createMovie(newMovie: MoviesDTORequest): MoviesDTOResponse {
        val save = moviesRepository.save(
            MoviesEntity(
                id = null,
                name = newMovie.name
            )
        )
        return MoviesDTOResponse(id = save.id!!, name = save.name)
    }
    
    fun getAllMovies(): List<MoviesDTOResponse> {
        return moviesRepository.findAll()
            .map { MoviesDTOResponse(id = it.id!!, name = it.name) }
            .ifEmpty { throw ResponseStatusException(HttpStatus.NOT_FOUND, "No movies found") }
    }

    fun getMovie(id: Long): MoviesDTOResponse {
        val movie = moviesRepository.findByIdOrNull(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Movie with id $id not found")
        
        return MoviesDTOResponse(id = movie.id!!, name = movie.name)
    }

    fun deleteMovie(id: Long) {
        // Throws IllegalArgumentException if ID is not found, so no logic needed
        moviesRepository.deleteById(id)
    }

    fun updateMovie(id: Long, updatedMovie: MoviesDTORequest): MoviesDTOResponse {
        return moviesRepository.findByIdOrNull(id)?.let { 
            foundMovie -> val updatedMovieEntity = foundMovie.copy(name = updatedMovie.name)
            val savedMovie = moviesRepository.save(updatedMovieEntity)
            MoviesDTOResponse(id = savedMovie.id!!, name = savedMovie.name)
        }
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Movie with id $id not found")
    }
    
}