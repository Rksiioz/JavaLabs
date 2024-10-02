package task7;

public class Task7 {
    public static void main(String[] args) {
        Bank bank1 = new Bank("Monobank");
        Bank bank2 = new Bank("Privatbank");

        User user1 = new User("Yukato");
        User user2 = new User("Rksiioz");

        BankAccount account1 = new BankAccount("1111", user1, bank1, 1000, "USD");
        BankAccount account2 = new BankAccount("2222", user1, bank1, 300, "UAH");
        BankAccount account3 = new BankAccount("3333", user2, bank1, 200, "CAD");
        BankAccount account4 = new BankAccount("4444", user2, bank2, 2000, "EUR");
        BankAccount account5 = new BankAccount("5555", user1, bank2, 500, "USD");
        BankAccount account6 = new BankAccount("5555", user1, bank2, 500, "USD");

        user1.addAccount(account1);
        user1.addAccount(account2);
        user1.addAccount(account5);
        user2.addAccount(account3);
        user2.addAccount(account4);

        // інформація про рахунки
        System.out.println("Рахунки користувача " + user1.getName() + ":");
        for (BankAccount account : user1.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getCurrency());
        }

        System.out.println("\nРахунки користувача " + user2.getName() + ":");
        for (BankAccount account : user2.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getCurrency());
        }

        // транзакції
        System.out.println("\nТранзакції:");

        System.out.println("\n1. Переказ між власними рахунками в межах одного банку (0% комісія):");
        account1.transfer(account2, 100);

        System.out.println("\n2. Переказ між власними рахунками у різних банках (2% комісія):");
        account1.transfer(account5, 100);

        System.out.println("\n3. Переказ між рахунками різних користувачів в одному банку (3% комісія):");
        account1.transfer(account3, 50);

        System.out.println("\n4. Переказ між рахунками різних користувачів у різних банках (6% комісія):");
        account1.transfer(account4, 50);

        // інформація про рахунки після транзакцій
        System.out.println("\nРахунки користувача " + user1.getName() + " після транзакцій:");
        for (BankAccount account : user1.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getCurrency());
        }

        System.out.println("\nРахунки користувача " + user2.getName() + " після транзакцій:");
        for (BankAccount account : user2.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getCurrency());
        }
    }
}


