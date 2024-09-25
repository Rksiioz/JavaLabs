package task7;

public class Task7 {
    public static void main(String[] args) {

        Bank bank1 = new Bank("Monobank", "USD");
        Bank bank2 = new Bank("Privatbank", "UAH");

        User user1 = new User("Yukato");
        User user2 = new User("Rksiioz");

        BankAccount account1 = new BankAccount(user1, bank1, 500);
        BankAccount account2 = new BankAccount(user1, bank1, 300);
        BankAccount account3 = new BankAccount(user2, bank1, 200);
        BankAccount account4 = new BankAccount(user2, bank2, 10000);
        BankAccount account5 = new BankAccount(user1, bank2, 5000);

        user1.addAccount(account1);
        user1.addAccount(account2);
        user1.addAccount(account5);
        user2.addAccount(account3);
        user2.addAccount(account4);

        // Інформація про рахунки до транзакційі
        System.out.println("Рахунки користувача " + user1.getName() + ":");
        for (BankAccount account : user1.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getBank().getCurrency());
        }

        System.out.println("\nРахунки користувача " + user2.getName() + ":");
        for (BankAccount account : user2.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getBank().getCurrency());
        }

        // Транзакції
        System.out.println("\nТранзакції:");

        System.out.println("\n1. Переказ між власними рахунками в межах одного банку (0% комісія):");
        account1.transfer(account2, 100);

        System.out.println("\n2. Переказ між власними рахунками у різних банках (2% комісія):");
        account1.transfer(account5, 100);

        System.out.println("\n3. Переказ між рахунками різних користувачів в одному банку (3% комісія):");
        account1.transfer(account3, 50);

        System.out.println("\n4. Переказ між рахунками різних користувачів у різних банках (6% комісія):");
        account1.transfer(account4, 50);


        //Інформація про рахунки після транзакцій
        System.out.println("\nРахунки користувача " + user1.getName() + " після транзакцій:");
        for (BankAccount account : user1.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getBank().getCurrency());
        }

        System.out.println("\nРахунки користувача " + user2.getName() + " після транзакцій:");
        for (BankAccount account : user2.getAccounts()) {
            System.out.println(account.getBank().getName() + ": " + account.getBalance() + " " + account.getBank().getCurrency());
        }
    }
}


