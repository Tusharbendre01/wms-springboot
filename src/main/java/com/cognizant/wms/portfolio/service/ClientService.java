package com.cognizant.wms.portfolio.service;

import com.cognizant.wms.portfolio.entity.ClientEntity;
import com.cognizant.wms.portfolio.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    // Register new client
    public ClientEntity registerClient(ClientEntity client) {
        return clientRepository.save(client);
    }

    // Update client profile
    public ClientEntity updateClientProfile(Long clientId, ClientEntity clientDetails) {
        Optional<ClientEntity> optionalClient = clientRepository.findById(clientId);
        if (optionalClient.isPresent()) {
            ClientEntity existingClient = optionalClient.get();
            existingClient.setName(clientDetails.getName());
            existingClient.setEmail(clientDetails.getEmail());
            existingClient.setPhone(clientDetails.getPhone());
            existingClient.setAddress(clientDetails.getAddress());
            existingClient.setDateOfBirth(clientDetails.getDateOfBirth());

            return clientRepository.save(existingClient);
        }
        return null;
    }

    // Get client details by ID
    public ClientEntity getClientDetails(Long clientId) {
        return clientRepository.findById(clientId).orElse(null);
    }

    // Get all clients
    public List<ClientEntity> getAllClients() {
        return clientRepository.findAll();
    }
}
