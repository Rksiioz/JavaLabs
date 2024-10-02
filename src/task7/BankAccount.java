package task7;

import task6.Converter;

import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private static final List<String> allAccountNumbers = new ArrayList<>(); // 3 part 1

    private final String accountNumber; // 2 task
    private final User user;
    private final Bank bank;
    private double balance;
    private final String currency; // 1 task

    public BankAccount(String accountNumber, User user, Bank bank, double initialBalance, String currency) {
        if (allAccountNumbers.contains(accountNumber)) { // 3 task 2 part
            System.out.println("Рахунок з номером " + accountNumber + " вже існує!");
        }
        this.accountNumber = accountNumber;
        this.user = user;
        this.bank = bank;
        this.balance = initialBalance;
        this.currency = currency;
        allAccountNumbers.add(accountNumber);
    }

    public User getUser() {
        return user;
    }

    public Bank getBank() {
        return bank;
    }

    public double getBalance() {
        return balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public void transfer(BankAccount targetAccount, double amount) {
        if (withdraw(amount)) {
            double convertedAmount = amount;
            if (!currency.equals(targetAccount.currency)) {
                convertedAmount = Converter.convertCurrency(amount, currency, targetAccount.currency);
            }

            double fee = calculateFee(targetAccount, amount);
            targetAccount.deposit(convertedAmount * (1 - fee));
            System.out.println("Переказ виконано з " + user.getName() + " " + getAccountNumber() +" " + " до " + targetAccount.getUser().getName() +
                    ". Сума: " + amount + " " + currency + " -> " + convertedAmount + " " + targetAccount.currency +
                    ". Комісія: " + (fee * 100) + "%");
        } else {
            System.out.println("Недостатньо коштів для переказу.");
        }
    }

    private double calculateFee(BankAccount targetAccount, double amount) {
        if (user.equals(targetAccount.getUser())) {
            if (bank.equals(targetAccount.getBank())) {
                return 0.0; // Комісія 0
            } else {
                return 0.02; // Комісія 2% для різних банків
            }
        } else {
            if (bank.equals(targetAccount.getBank())) {
                return 0.03; // Комісія 3% для різних користувачів у тому ж банку
            } else {
                return 0.06; // Комісія 6% для різних користувачів у різних банках
            }
        }
    }
}
