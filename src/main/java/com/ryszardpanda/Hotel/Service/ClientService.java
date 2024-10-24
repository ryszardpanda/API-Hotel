package com.ryszardpanda.Hotel.Service;

import com.ryszardpanda.Hotel.Model.Client;
import com.ryszardpanda.Hotel.Repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //przechowują logikę aplikacji
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;

    public List<Client> getClients() {
        return clientRepository.getClients();
    }

    public Client addClient(Client client) {
        return clientRepository.addClient(client);
    }

    public Client getClientByEmail(String email) {
        return clientRepository.getClientByEmail(email).orElseThrow(() -> new IllegalArgumentException("Client with given email doesnt exist"));
    }

    public boolean deleteClientByEmail(String email) {
        return clientRepository.deleteClientByEmail(email); // Wywołanie metody z repozytorium
    }

    public Client updatePatient(String email, Client updatedClient) {
        return clientRepository.updateClient(email, updatedClient).orElseThrow(() -> new IllegalArgumentException("Client with given email doesnt exist"));  // Wywołanie metody z repozytorium
    }
}
