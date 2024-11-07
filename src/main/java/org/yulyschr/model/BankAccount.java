package org.yulyschr.model;

import java.util.Random;

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
    //metodo para generar numero de cuenta aleatorio
    private String generateAccountNumber(AccountType accountType) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        String prefix = accountType == AccountType.ahorros ? "CA-" : "CC-";
        return prefix + String.format("%03d", randomNumber);
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
        return "Titular: " +client.getDni() + " Cuenta " + accountType + " - Numero de Cuenta: " + accountNumber + ", Saldo: " + accountBalance;
    }

}

