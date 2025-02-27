package com.cognizant.wms.portfolio.controller;

import com.cognizant.wms.portfolio.entity.ClientEntity;
import com.cognizant.wms.portfolio.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    // Register new client
    @PostMapping("/register")
    public ResponseEntity<ClientEntity> registerClient(@RequestBody ClientEntity client) {
        return ResponseEntity.ok(clientService.registerClient(client));
    }

    // Update client profile
    @PutMapping("/update/{clientId}")
    public ResponseEntity<ClientEntity> updateClientProfile(
            @PathVariable Long clientId,
            @RequestBody ClientEntity clientDetails) {
        ClientEntity updatedClient = clientService.updateClientProfile(clientId, clientDetails);
        return (updatedClient != null) ? ResponseEntity.ok(updatedClient) : ResponseEntity.notFound().build();
    }

    // Get client by ID
    @GetMapping("/{clientId}")
    public ResponseEntity<ClientEntity> getClientDetails(@PathVariable Long clientId) {
        ClientEntity client = clientService.getClientDetails(clientId);
        return (client != null) ? ResponseEntity.ok(client) : ResponseEntity.notFound().build();
    }

    // Get all clients
    @GetMapping("/all")
    public ResponseEntity<List<ClientEntity>> getAllClients() {
        return ResponseEntity.ok(clientService.getAllClients());
    }
}
