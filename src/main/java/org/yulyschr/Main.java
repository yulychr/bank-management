package org.yulyschr;

import org.yulyschr.model.AccountType;
import org.yulyschr.model.BankAccount;
import org.yulyschr.model.Client;
import org.yulyschr.model.Transaction;
import org.yulyschr.model.Manager;

public class Main {
    public static void main(String[] args) throws Exception {
        //BankAccount bank = new BankAccount();
        Client client = new Client();
        Manager admin = new Manager();

        Client cliente1 = new Client("Alonso", "Godinez", "45659874", "alonos@mail.com");
        admin.addClient(cliente1);
        Client cliente2 = new Client("Dina", "Vela", "87654321", "dina@mail.com");
        admin.addClient(cliente2);
        Client cliente3 = new Client("Alicia", "Cotrado", "87654321", "alicia@mail.com");
        admin.addClient(cliente3);
        Client cliente4 = new Client(null, "Jinez", "12345678", "dina.@mail.com");
        admin.addClient(cliente4);
        Client cliente5 = new Client("Juana", "Berrios", "16597582", "juana-mail.com");
        admin.addClient(cliente5);


        BankAccount cuenta1 = new BankAccount(cliente1, AccountType.ahorro);
        BankAccount cuenta2 = new BankAccount(cliente1, AccountType.ahorro);
        BankAccount cuenta3 = new BankAccount(cliente1, AccountType.ahorro);
        BankAccount cuenta4 = new BankAccount(cliente2, AccountType.ahorro);
        BankAccount cuenta5 = new BankAccount(cliente1, AccountType.corriente);

        admin.addAccount(cuenta1,cliente1);
        admin.addAccount(cuenta2, cliente1);
        admin.addAccount(cuenta3,cliente1);
        admin.addAccount(cuenta4,cliente2);
        admin.addAccount(cuenta5,cliente1);

        System.out.println("\n"+"Transaccion: deposito");
        System.out.println("******************");
        Transaction trans = new Transaction(-10, "deposito",cuenta1);
        trans.execute();
        Transaction trans1 = new Transaction(500, "deposito",cuenta2);
        trans1.execute();
        Transaction trans2 = new Transaction(300, "deposito",cuenta4);
        trans2.execute();

        System.out.println("\n"+"Transaccion: retiro");
        System.out.println("******************");
        Transaction trans3 = new Transaction(100, "retiro",cuenta4);
        trans3.execute();
        Transaction trans4 = new Transaction(50, "retiro", cuenta1);
        trans4.execute();
        Transaction trans5 = new Transaction(600, "retiro", cuenta5);
        trans5.execute();

        System.out.println("\n"+"Consultar Saldo:");
        System.out.println("******************");
        admin.checkBalance(cliente1.getDni(),cuenta1.getAccountNumber());
        admin.checkBalance(cliente2.getDni(),cuenta4.getAccountNumber());
        admin.checkBalance(cliente2.getDni());



       System.out.println("\n"+"Clientes registrados:");
        System.out.println("**********************");
       admin.clientList();



        System.out.println("\n"+"Cuentas registradas:");
        System.out.println("**********************");
        admin.accountsList();








    }


}