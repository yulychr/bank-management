package org.yulyschr.service;
import org.yulyschr.model.Client;

import java.util.HashSet;
import java.util.Set;
public class ClientManager {
    private Set<Client> clients;

    public ClientManager() {
        this.clients = new HashSet<>();
    }

    // Método para agregar un cliente
    public void addClient(Client client) throws Exception {
        // Verificar que el DNI no se repita
        for (Client c : clients) {
            if (c.getDni().equals(client.getDni())) {
                throw new IllegalArgumentException("El DNI " + client.getDni() + " ya está registrado.");
            }
        }
        // Si el DNI es único, agregar el cliente al conjunto
        clients.add(client);
    }

    // Método para listar todos los clientes
    public void clientList() {
        clients.forEach(client -> System.out.println(client));
    }
}
