package com.alx.cinebook.controllers

import com.alx.cinebook.services.ClientService
import com.alx.cinebook.models.ClientDTORequest
import com.alx.cinebook.models.ClientDTOResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException


@RestController
@RequestMapping("/clients")
class ClientsController(var clientService: ClientService) {

    @PostMapping("/create")
    fun createTask(@RequestBody newClient: ClientDTORequest): ClientDTOResponse {
        return clientService.createTask(newClient)
    }

    @GetMapping("/{id}")
    fun getTask(@PathVariable id: Long): ClientDTOResponse {
        return clientService.getTask(id)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
    }

    @DeleteMapping("/{id}")
    fun deleteTask(@PathVariable id: Long) {
        clientService.deleteTask(id)
    }

    @PutMapping("/{id}")
    fun updateTask(@PathVariable id: Long, @RequestBody updatedTask: ClientDTORequest): ClientDTOResponse {
        return clientService.updateTask(id, updatedTask)
            ?: throw ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found")
    }
    
}