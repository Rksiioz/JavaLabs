package task7;

import task6.Converter;

public class BankAccount {
    private User user;
    private Bank bank;
    private double balance;

    public BankAccount(User user, Bank bank, double initialBalance) {
        this.user = user;
        this.bank = bank;
        this.balance = initialBalance;
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

    public void deposit(double amount) {
        this.balance += amount;
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
            if (!bank.getCurrency().equals(targetAccount.getBank().getCurrency())) {
                convertedAmount = Converter.convertCurrency(amount, bank.getCurrency(), targetAccount.getBank().getCurrency());
            }

            double fee = calculateFee(targetAccount, amount);
            targetAccount.deposit(convertedAmount * (1 - fee));
            System.out.println("Переказ виконано з " + user.getName() + " до " + targetAccount.getUser().getName() +
                    ". Сума: " + amount + " " + bank.getCurrency() + " -> " + convertedAmount + " " + targetAccount.getBank().getCurrency() +
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
                return 0.02; // Комісія 2
            }
        } else {
            if (bank.equals(targetAccount.getBank())) {
                return 0.03; // Комісія 3
            } else {
                return 0.06; // Комісія 4
            }
        }
    }
}

