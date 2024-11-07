package org.yulyschr;

import org.yulyschr.model.AccountType;
import org.yulyschr.model.BankAccount;
import org.yulyschr.model.Client;
import org.yulyschr.service.ClientManager;

public class Main {
    public static void main(String[] args) throws Exception {


        ClientManager admin = new ClientManager();



        Client cliente1 = new Client("Juan", "Pérez", "12345678", "juan.perez@mail.com");
        Client cliente2 = new Client("Dina", "Gómez", "87654321", "dina.gomez@mail.com");

        admin.addClient(cliente1);
        admin.addClient(cliente2);


        System.out.println("Clientes registrados:");
        admin.clientList();


        // Crear una cuenta bancaria para el cliente, usando el DNI del cliente
        BankAccount cuenta1 = new BankAccount(cliente1, AccountType.ahorros);
        BankAccount cuenta2 = new BankAccount(cliente2, AccountType.ahorros);

        System.out.println(cuenta1);
        System.out.println(cuenta2);


    }

}