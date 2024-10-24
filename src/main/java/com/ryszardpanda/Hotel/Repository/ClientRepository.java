package com.ryszardpanda.Hotel.Repository;

import com.ryszardpanda.Hotel.Model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository // służy do oznaczania komponentów, które pełnią rolę warstwy dostępu do danych
@RequiredArgsConstructor
public class ClientRepository {

    private final List<Client> clients;

    public List<Client> getClients() {
        return new ArrayList<>(clients);
    }

    public Client addClient(Client client) {
        clients.add(client);
        return client;
    }

    public Optional<Client> getClientByEmail(String email) {
        // Zakładam, że email jest unikalny, więc szukamy pierwszego pasującego
        return clients.stream()
                .filter(client -> client.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public boolean deleteClientByEmail(String email) {
        return clients.removeIf(client -> client.getEmail().equalsIgnoreCase(email));
    }

    public Optional<Client> updateClient(String email, Client updatedClient) {
        Optional<Client> optionalClient = getClientByEmail(email);
        optionalClient.ifPresent(client -> {
            client.setName(updatedClient.getName());
            client.setSurname(updatedClient.getSurname());
            client.setEmail(updatedClient.getEmail());
        });
        return optionalClient;
    }
}
