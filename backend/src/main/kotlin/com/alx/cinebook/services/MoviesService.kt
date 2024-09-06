package com.alx.cinebook.services

import com.alx.cinebook.repositories.MoviesEntity
import com.alx.cinebook.repositories.MoviesRepository
import com.alx.cinebook.models.MoviesDTORequest
import com.alx.cinebook.models.MoviesDTOResponse
import org.springframework.stereotype.Service
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
    }

    fun getMovie(id: Long): MoviesDTOResponse? {
        return moviesRepository.findById(id)
            .map { MoviesDTOResponse(id = it.id!!, name = it.name) }
            .getOrNull()
    }

    fun deleteMovie(id: Long) {
        moviesRepository.deleteById(id)
    }

    fun updateMovie(id: Long, updatedMovie: MoviesDTORequest): MoviesDTOResponse? {
        return moviesRepository.findById(id).map {
            val save = moviesRepository.save(
                MoviesEntity(
                    id = it.id,
                    name = updatedMovie.name,
                )
            )
            MoviesDTOResponse(id = save.id!!, name = save.name)
        }.orElseGet(null)
    }
    
}