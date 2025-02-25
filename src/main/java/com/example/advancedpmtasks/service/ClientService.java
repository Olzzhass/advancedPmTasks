package com.example.advancedpmtasks.service;

import com.example.advancedpmtasks.entity.Client;
import com.example.advancedpmtasks.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {
    private final ClientRepository clientRepository;

    public Client registerClient(String name) {
        Client client = new Client();
        client.setName(name);
        client.setBalance(BigDecimal.ZERO);
        return clientRepository.save(client);
    }

    public Client deposit(Long clientId, BigDecimal amount) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        client.setBalance(client.getBalance().add(amount));
        return clientRepository.save(client);
    }

    public Client withdraw(Long clientId, BigDecimal amount) {
        Client client = clientRepository.findById(clientId).orElseThrow();
        if (client.getBalance().compareTo(amount) < 0) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        client.setBalance(client.getBalance().subtract(amount));
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}