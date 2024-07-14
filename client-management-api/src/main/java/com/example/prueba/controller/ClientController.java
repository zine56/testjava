package com.example.prueba.controller;

import com.example.prueba.model.Client;
import com.example.prueba.service.ClientService;
import com.example.prueba.service.EmailValidationService;
import com.example.prueba.dto.EmailValidationResponse; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private ClientService service;

    @Autowired
    private EmailValidationService emailValidationService;

    @GetMapping
    public List<Client> getAllClients() {
        return service.getAllClients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) {
        return service.getClientById(id)
                .map(client -> ResponseEntity.ok().body(client))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return service.saveClient(client);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client clientDetails) {
        return service.getClientById(id)
                .map(client -> {
                    client.setName(clientDetails.getName());
                    client.setEmail(clientDetails.getEmail());
                    client.setPhone(clientDetails.getPhone());
                    Client updatedClient = service.saveClient(client);
                    return ResponseEntity.ok().body(updatedClient);
                }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
        return service.getClientById(id)
                .map(client -> {
                    service.deleteClient(id);
                    return new ResponseEntity<Void>(HttpStatus.OK);
                }).orElse(new ResponseEntity<Void>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/validate-email")
    public EmailValidationResponse validateEmail(@RequestParam String email) {
        return emailValidationService.validateEmail(email);
    }
}
