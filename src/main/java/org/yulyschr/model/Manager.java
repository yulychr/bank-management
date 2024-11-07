package org.yulyschr.model;

import java.util.ArrayList;

import java.util.List;


public class Manager {
    private List<BankAccount> accounts;
    private List<Client> clients;

    public Manager() {

        this.accounts = new ArrayList<>();
        this.clients = new ArrayList<>();
    }
    //metodo para generar una cuenta enlazada a un cliente
    public void addAccount(BankAccount account , Client client) {
        try {
            // verifica que el cliente y la cuenta no sean nulos.
            if (account == null || client == null ) {
                throw new IllegalArgumentException("La cuenta o el cliente no son válidos.");
            }
            // Verificar si la cuenta ya está asociada al cliente
            if (!client.getAccounts().contains(account)) {
                client.addAccount(account);  // Agregar la cuenta a la lista de cuentas del cliente
                accounts.add(account);       // Agregar la cuenta a la lista global de cuentas
                System.out.println("Cliente: "+client.getDni()+" abre una cuenta "+account.getAccountType() +" "+ account.getAccountNumber());
            } else {
                System.out.println("La cuenta ya está asociada a este cliente.");
            }
        } catch (IllegalArgumentException e) {

            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {

            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }


    // Método para agregar un cliente
    public void addClient(Client client) {
        try {
            // Verificar que ningun valor de cliente sea nulo
            if (client == null) {
                throw new IllegalArgumentException("El cliente no puede ser nulo.");
            }
            if (client.getFirstName() == null || client.getFirstName().isEmpty()) {
                throw new IllegalArgumentException("El nombre del cliente no puede ser nulo o vacío.");
            }
            if (client.getLastName() == null || client.getLastName().isEmpty()) {
                throw new IllegalArgumentException("El apellido del cliente no puede ser nulo o vacío.");
            }
            if (client.getDni() == null || client.getDni().isEmpty()) {
                throw new IllegalArgumentException("El DNI del cliente no puede ser nulo o vacío.");
            }
            if (client.getEmail() == null || client.getEmail().isEmpty()) {
                throw new IllegalArgumentException("El correo electrónico del cliente no puede ser nulo o vacío.");
            }

            // Validar el formato del email (una validación básica)
            if (!client.getEmail().contains("@") || !client.getEmail().contains(".")) {
                throw new IllegalArgumentException("El correo electrónico del cliente no tiene un formato válido.");
            }

            // Verfica que el dni no se repita
            for (Client c : clients) {
                if (client.getDni().equals(c.getDni())) {
                    throw new IllegalArgumentException("El DNI " + client.getDni() + " ya está registrado.");
                }
            }
            // Agregar el cliente si todas las verificaciones son exitosas
            clients.add(client);
            System.out.println("Cliente agregado exitosamente."+client.getDni());
        } catch (IllegalArgumentException e) {
            // Capturar y manejar las excepciones, mostrando el mensaje de error
            System.out.println("Error al agregar cliente: " + e.getMessage());
        }

    }
    // metodo para listar cuentas
    public void accountsList() {
        if (accounts.isEmpty()) {
            System.out.println("La lista de cuentas está vacía.");
        } else {
            accounts.forEach(account -> System.out.println("Tipo de Cuenta: "+account.getAccountType()+" Numero cuenta:  "+account.getAccountNumber()));
        }
    }

    // metodo para listar todos los clientes
    public void clientList() {
        clients.forEach(client -> System.out.println(client));
    }

    // Método para encontrar un cliente por su DNI
    public Client searchClientDni(String dni) {
        return clients.stream()
                .filter(client -> client.getDni().equals(dni))
                .findFirst()
                .orElse(null); // Si no se encuentra el cliente, devuelve null
    }

    // Método para consultar el saldo de una cuenta bancaria de un cliente
    public void checkBalance(String dni, String accountNumber) {

        Client client = searchClientDni(dni);
        if (client != null) {
            System.out.println("El Cliente DNI: "+dni);
            client.checkBalance(accountNumber);

        } else {
            System.out.println("Cliente no encontrado.");
        }
    }
    public void checkBalance(String dni) {

        Client client = searchClientDni(dni);
        if (client != null) {
            System.out.println("El cliente DNI: "+dni);
            client.checkBalance();

        } else {
            System.out.println("Cliente no encontrado.");
        }
    }






}
