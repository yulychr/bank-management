package org.yulyschr.model;

import java.util.Objects;
public class Transaction {
    private double amount;
    private String typeTransaction ;
    private BankAccount bankAccount;


    public Transaction() {

    }

    public Transaction(double amount, String typeTransaction, BankAccount bankAccount) {
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
            bankAccount.depossit(amount, bankAccount);

        } else if (Objects.equals(this.typeTransaction, "retiro")) {
            bankAccount.withdrawal(amount,bankAccount);
        }
    }


}
