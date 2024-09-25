package task6;

import java.util.Scanner;
import task6.Converter;

public class Task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть запит у вигляді '100 UAH into USD': ");
        String input = scanner.nextLine();

        String[] parts = input.split(" "); // поділ елементів запиту через пробіл на масиви стрінгів
        double amount = Double.parseDouble(parts[0]);
        String fromCurrency = parts[1];
        String toCurrency = parts[3];

        double result = Converter.convertCurrency(amount, fromCurrency, toCurrency);

        if (result != -1) {
            System.out.print( amount + " " + fromCurrency.toUpperCase() + " = " + result + " " + toCurrency.toUpperCase());
        } else {
            System.out.println("Невірний запит або валюта не підтримується.");
        }

        scanner.close();
    }
}


