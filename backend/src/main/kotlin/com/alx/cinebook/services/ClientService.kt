package com.alx.cinebook.services

import com.alx.cinebook.repositories.ClientEntity
import com.alx.cinebook.repositories.ClientRepository
import com.alx.cinebook.models.ClientDTORequest
import com.alx.cinebook.models.ClientDTOResponse
import org.springframework.stereotype.Service
import kotlin.jvm.optionals.getOrNull

@Service
class ClientService(var clientRepository: ClientRepository) {

    fun createTask(newClient: ClientDTORequest): ClientDTOResponse {
        val save = clientRepository.save(
            ClientEntity(
                id = null,
                name = newClient.name
            )
        )
        return ClientDTOResponse(id = save.id!!, name = save.name)
    }

    fun getTask(id: Long): ClientDTOResponse? {
        return clientRepository.findById(id)
            .map { ClientDTOResponse(id = it.id!!, name = it.name) }
            .getOrNull()
    }

    fun deleteTask(id: Long) {
        clientRepository.deleteById(id)
    }

    fun updateTask(id: Long, updatedClient: ClientDTORequest): ClientDTOResponse? {
        return clientRepository.findById(id).map {
            val save = clientRepository.save(
                ClientEntity(
                    id = it.id,
                    name = updatedClient.name,
                )
            )
            ClientDTOResponse(id = save.id!!, name = save.name)
        }.orElseGet(null)
    }
    
}