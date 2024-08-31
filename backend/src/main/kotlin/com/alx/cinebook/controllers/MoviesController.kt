package com.alx.cinebook.controllers

import com.alx.cinebook.services.MoviesService
import com.alx.cinebook.models.MoviesDTORequest
import com.alx.cinebook.models.MoviesDTOResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/movie")
class MoviesController(var moviesService: MoviesService) {

    @PostMapping("/create")
    fun createMovie(@RequestBody newClient: MoviesDTORequest): MoviesDTOResponse {
        return moviesService.createMovie(newClient)
    }
    
    @GetMapping("/list")
    fun getAllMovies(): List<MoviesDTOResponse> {
        return moviesService.getAllMovies()
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "No movies found")
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