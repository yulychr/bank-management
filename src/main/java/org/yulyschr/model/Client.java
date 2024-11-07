package org.yulyschr.model;

import java.util.ArrayList;
import java.util.List;


public class Client {
    private String firstName;
    private String lastName;
    private String dni;
    private String email;
    private List<BankAccount> accounts;

    public Client() {
        this.accounts = new ArrayList<>();
    }


    //metodo cliente para validar daots y asignar valores
    public Client(String firstName, String lastName, String dni, String email) {
        try {
            // Verificar que todos los campos sean proporcionados
            if (firstName == null || lastName == null || dni == null || email == null) {
                throw new IllegalArgumentException("Todos los campos son obligatorios.");
            }

            // Validar que el email tenga un formato correcto
            if (!email.contains("@")) {
                throw new IllegalArgumentException("El email no tiene un formato válido.");
            }
            if (dni == null || dni.isEmpty()) {
                throw new IllegalArgumentException("El DNI no puede ser nulo o vacío.");
            }

            // Asignar los valores a las variables de instancia
            this.firstName = firstName;
            this.lastName = lastName;
            this.dni = dni;
            this.email = email;
            this.accounts = new ArrayList<>();

        } catch (IllegalArgumentException e) {
            // Capturar y manejar las excepciones, pero permitir que el programa siga ejecutándose
            System.out.println("Error al crear el cliente: " + e.getMessage());
        }

    }
    // metodo para agregar una cuenta a la lista del cliente
    public void addAccount(BankAccount account) {
        if (account != null && !accounts.contains(account)) {
            accounts.add(account);

        }
    }
    public void checkBalance(String accountNumber) {
        // Buscar la cuenta en la lista de cuentas del cliente
        BankAccount account = accounts.stream()
                .filter(c -> c.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElse(null); // Si no se encuentra, devuelve null

        if (account != null) {
            System.out.println("Tiene Saldo de la cuenta " + accountNumber + ": " + account.getAccountBalance());
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void checkBalance() {
        // Verificar si la lista de cuentas está vacía
        if (accounts.isEmpty()) {
            System.out.println("El cliente no tiene cuentas bancarias.");
        } else {
            // Usar Stream para recorrer y mostrar los saldos de todas las cuentas
            accounts.stream()
                    .filter(account -> account != null)  // Filtrar cuentas no nulas
                    .forEach(account ->
                            System.out.println("Tiene saldo de la cuenta " + account.getAccountNumber() + ": " + account.getAccountBalance())
                    );
        }

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
    //metodo para mostrar cliente
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente: ").append(firstName).append(" ").append(lastName).append("\n");
        sb.append("DNI: ").append(dni).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Cuentas bancarias:\n");

        // Verifica si el cliente tiene cuentas y las imprime
        if (accounts != null && !accounts.isEmpty()) {
            for (BankAccount account : accounts) {
                sb.append("- " + account.getAccountNumber().toString()).append("\n"); // Llama al toString() de la clase BankAccount
            }
        } else {
            sb.append("No tiene cuentas bancarias asociadas.");
        }

        return sb.toString();
    }




}


