package com.example.prueba.service;

import com.example.prueba.dto.EmailValidationResponse;
import com.example.prueba.constants.ValidationConstants; 
import com.example.prueba.model.Client;
import com.example.prueba.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repository;

    @Autowired
    private EmailValidationService emailValidationService;

    public List<Client> getAllClients() {
        return repository.findAll();
    }

    public Optional<Client> getClientById(Long id) {
        return repository.findById(id);
    }

    public Client saveClient(Client client) {
        return repository.save(client);
    }

    public void deleteClient(Long id) {
        repository.deleteById(id);
    }

    private void validateEmail(String email) {
        EmailValidationResponse validationResponse = emailValidationService.validateEmail(email);
        if (!ValidationConstants.DELIVERABLE.equals(validationResponse.getDeliverability())) {
            throw new IllegalArgumentException("Email is not deliverable");
        }
    }
}
