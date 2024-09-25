package task7;

import task6.Converter;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private List<BankAccount> accounts = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public List<BankAccount> getAccounts() {
        return accounts;
    }
}

