package com.example.advancedpmtasks.controller;

import com.example.advancedpmtasks.entity.Client;
import com.example.advancedpmtasks.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("/register")
    public Client register(@RequestParam String name) {
        return clientService.registerClient(name);
    }

    @PostMapping("/deposit")
    public Client deposit(@RequestParam Long clientId, @RequestParam BigDecimal amount) {
        return clientService.deposit(clientId, amount);
    }

    @PostMapping("/withdraw")
    public Client withdraw(@RequestParam Long clientId, @RequestParam BigDecimal amount) {
        return clientService.withdraw(clientId, amount);
    }

    @GetMapping("/all")
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }
}