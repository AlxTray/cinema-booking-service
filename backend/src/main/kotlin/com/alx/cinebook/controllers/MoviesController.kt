package com.alx.cinebook.controllers

import com.alx.cinebook.services.MoviesService
import com.alx.cinebook.models.MoviesDTORequest
import com.alx.cinebook.models.MoviesDTOResponse
import org.apache.coyote.Response
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/movie")
class MoviesController(var moviesService: MoviesService) {

    @PostMapping("/create")
    fun createMovie(@RequestBody newMovie: MoviesDTORequest): ResponseEntity<MoviesDTOResponse> {
        val newMovieResponse = moviesService.createMovie(newMovie)
        return ResponseEntity.status(HttpStatus.CREATED).body(newMovieResponse)
    }
    
    @GetMapping("/list")
    fun getAllMovies(): ResponseEntity<List<MoviesDTOResponse>> {
        val listMoviesResponse = moviesService.getAllMovies()
        return if (listMoviesResponse.isNotEmpty())
            ResponseEntity.status(HttpStatus.NOT_FOUND).build()
        else
            ResponseEntity.status(HttpStatus.OK).body(listMoviesResponse)
    }

    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: Long): MoviesDTOResponse {
        return moviesService.getMovie(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")
    }

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: Long) {
        moviesService.deleteMovie(id)
    }

    @PutMapping("/{id}")
    fun updateMovie(@PathVariable id: Long, @RequestBody updatedTask: MoviesDTORequest): MoviesDTOResponse {
        return moviesService.updateMovie(id, updatedTask)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Movie not found")
    }
    
}