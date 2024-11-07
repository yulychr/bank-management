package org.yulyschr.model;

import java.util.List;
import java.util.Random;
import java.util.UUID;

public class BankAccount {
    private String accountNumber;
    private double accountBalance;
    private AccountType accountType;
    private Client client;

    public BankAccount(Client client, AccountType accountType) {
        this.accountType = accountType;
        this.accountBalance = 0.0;
        this.client = client;
        this.accountNumber = generateAccountNumber(accountType); 
    }
    //metodo para generar numero de cuenta unico y aleatorio
    private String generateAccountNumber(AccountType accountType) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000000);
        // Inserta un prefijo Cuenta de ahorros:4520 y cuenta corriente :1000
        String prefix = accountType == AccountType.ahorro ? "4520 " : "1000 ";
        String accountNumbers = prefix + String.format("%06d", randomNumber);
        return accountNumbers;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }
    public String toString(){
        return " Cuenta " + accountType + " - Numero de Cuenta: " + accountNumber + ", Saldo: " + accountBalance;
    }
    //metodo para depositar dinero
    public void depossit(double amount, BankAccount bankAccount){
        if (amount > 0) {
            double balance = bankAccount.getAccountBalance();
            bankAccount.setAccountBalance(balance + amount);
            System.out.println("Depósito realizado con éxito. Nuevo saldo "+bankAccount.getAccountNumber()+": " + bankAccount.getAccountBalance()) ;
        } else {
            System.out.println("El monto a depositar debe de ser mayor a 0.");
        }
    }
    //metodo para realizar retiro
    public void withdrawal(double amount, BankAccount bankAccount){
        try {
            // Verifica que el monto a retirar sea positivo
            if (amount <= 0) {
                throw new IllegalArgumentException("El monto a retirar debe ser positivo.");
            }

            // Verifica que la cuenta bancaria no sea nula
            if (bankAccount == null) {
                throw new IllegalArgumentException("La cuenta bancaria no puede ser nula.");
            }

            // Para las cuentas de ahorro, el saldo no puede quedar en negativo.
            if (bankAccount.getAccountType() == AccountType.ahorro && bankAccount.getAccountBalance() - amount < 0) {
                throw new IllegalArgumentException("No se puede retirar dinero. La cuenta de ahorros no puede tener saldo negativo.");
            }

            // Para las cuentas corrientes, el saldo puede ser negativo, pero no debe exceder el límite de sobregiro de -500.00.
            double overturnLimit = 500;
            if (bankAccount.getAccountType() == AccountType.corriente && bankAccount.getAccountBalance() - amount < -overturnLimit) {
                throw new IllegalArgumentException("No se puede retirar dinero. El saldo no puede exceder el límite de sobregiro de -500.");
            }

            // Realiza el retiro
            double balance = bankAccount.getAccountBalance();
            bankAccount.setAccountBalance(balance - amount);
            System.out.println("Retiro realizado con éxito. Nuevo saldo en la cuenta " + bankAccount.getAccountNumber() + ": " + bankAccount.getAccountBalance());

        } catch (IllegalArgumentException e) {
            // Captura los errores relacionados con los argumentos, como monto negativo o saldo insuficiente
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            // Captura cualquier otra excepción inesperada
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        }
    }




}

