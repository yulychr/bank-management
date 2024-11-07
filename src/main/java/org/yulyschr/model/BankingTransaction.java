package org.yulyschr.model;

import java.util.Objects;
public class BankingTransaction {
    private double amount;
    private String typeTransaction ;
    private BankAccount bankAccount;

    public BankingTransaction() {

    }

    public BankingTransaction(double amount, String typeTransaction, BankAccount bankAccount) {
        this.amount = amount;
        this.typeTransaction = typeTransaction;
        this.bankAccount = bankAccount;
    }

    public String getTypeTransaction() {
        return typeTransaction;
    }

    public void setTypeTransaction(String typeTransaction) {
        this.typeTransaction = typeTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void execute() {
        if (Objects.equals(this.typeTransaction, "deposito")) {
            if (amount > 0) {
                double balance = this.bankAccount.getAccountBalance();
                this.bankAccount.setAccountBalance(balance + amount);
                System.out.println("Depósito realizado con éxito. Nuevo saldo: " + this.bankAccount.getAccountBalance()) ;
            } else {
                System.out.println("El monto a depositar debe de ser mayor a 0.");
            }
        }
    }


}
