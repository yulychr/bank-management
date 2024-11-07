package org.yulyschr.model;

import java.util.List;

public class Client {
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private List<BankAccount> accounts;

    // Constructor
    public Client() {

    }

    public Client(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public Client(String firstName, String lastName, String dni, String email) {
        if (firstName == null || lastName == null || dni == null || email == null) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        if (!email.contains("@")) {
            throw new IllegalArgumentException("El email no tiene un formato válido.");
        }
        this.firstName = firstName;
        this.lastName = lastName;
        this.dni = dni;
        this.email = email;
    }

    // Getters y Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    // Metodo para poder ver al cliente registrado
    public String toString() {

        return "Client [First Name=" + firstName + ", Last Name=" + lastName + ", DNI=" + dni +
                ", Email=" + email + "]";
    }

}


