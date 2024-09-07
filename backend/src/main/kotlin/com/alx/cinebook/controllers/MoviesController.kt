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
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(moviesService.createMovie(newMovie))
    }
    
    @GetMapping("/list")
    fun getAllMovies(): ResponseEntity<List<MoviesDTOResponse>> {
        return ResponseEntity.ok(moviesService.getAllMovies())
    }

    @GetMapping("/{id}")
    fun getMovie(@PathVariable id: Long): ResponseEntity<MoviesDTOResponse> {
        return ResponseEntity.ok(moviesService.getMovie(id))
    }

    @DeleteMapping("/{id}")
    fun deleteMovie(@PathVariable id: Long) {
        moviesService.deleteMovie(id)
    }

    @PutMapping("/{id}")
    fun updateMovie(@PathVariable id: Long, @RequestBody updatedTask: MoviesDTORequest): ResponseEntity<MoviesDTOResponse> {
        return ResponseEntity.ok(moviesService.updateMovie(id, updatedTask))
    }
    
}