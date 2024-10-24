package com.ryszardpanda.Hotel.Controller;

import com.ryszardpanda.Hotel.Model.Client;
import com.ryszardpanda.Hotel.Service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // mowie ze to jest Bean Springowy oraz kontroler -> czyli tutaj bede przechwytywal zapytania
@RequiredArgsConstructor

public class ClientController {

    private final ClientService clientService;

    // to jest po prostu definicja endpointu na sciezce "/patients"
    // GET /patients
    @GetMapping("/clients")
    public List<Client> getClients() {
        return clientService.getClients();
    }

    @PostMapping("/clients")
    public Client addClients(@RequestBody Client client) {
        return clientService.addClient(client);
    }

    @GetMapping("/clients/{email}")
    public Client getClientByEmail(@PathVariable String email) {
        return clientService.getClientByEmail(email);
    }

    // Metoda DELETE, która usunie pacjenta na podstawie adresu e-mail
    //nie ogarnalbym
    @DeleteMapping("/clients/{email}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteClientByEmail(@PathVariable String email) {
        boolean deleted = clientService.deleteClientByEmail(email);
    }

    // Metoda PUT, która edytuje pacjenta na podstawie adresu e-mail
    @PutMapping("/clients/{email}")
    public Client updateCleint(@PathVariable String email, @RequestBody Client updatedClient) {
        return clientService.updatePatient(email, updatedClient);
    }
}
