package task6;

public class Converter {

    static final double UAH_TO_USD = 0.024;
    static final double UAH_TO_EUR = 0.022;
    static final double UAH_TO_CAD = 0.033;
    static final double USD_TO_UAH = 41.33;
    static final double EUR_TO_UAH = 46.09;
    static final double CAD_TO_UAH = 30.65;
    static final double USD_TO_EUR = 0.90;
    static final double EUR_TO_USD = 1.12;
    static final double USD_TO_CAD = 1.35;
    static final double CAD_TO_USD = 0.74;
    static final double EUR_TO_CAD = 1.50;
    static final double CAD_TO_EUR = 0.66;

    public static double convertCurrency(double amount, String from, String to) {
        if (from.equalsIgnoreCase("UAH")) { // порівняння стрінгів без врахування реєстру
            switch (to.toUpperCase()) { // додав UpperCase, якщо хтось введе маленькі літери
                case "USD": return amount * UAH_TO_USD;
                case "EUR": return amount * UAH_TO_EUR;
                case "CAD": return amount * UAH_TO_CAD;
            }
        } else if (from.equalsIgnoreCase("USD")) { // порівняння стрінгів без врахування реєстру
            switch (to.toUpperCase()) { // додав UpperCase, якщо хтось введе маленькі літери
                case "UAH": return amount * USD_TO_UAH;
                case "EUR": return amount * USD_TO_EUR;
                case "CAD": return amount * USD_TO_CAD;
            }
        } else if (from.equalsIgnoreCase("EUR")) { // порівняння стрінгів без врахування реєстру
            switch (to.toUpperCase()) { // додав UpperCase, якщо хтось введе маленькі літери
                case "UAH": return amount * EUR_TO_UAH;
                case "USD": return amount * EUR_TO_USD;
                case "CAD": return amount * EUR_TO_CAD;
            }
        } else if (from.equalsIgnoreCase("CAD")) { // порівняння стрінгів без врахування реєстру
            switch (to.toUpperCase()) { // додав UpperCase, якщо хтось введе маленькі літери
                case "UAH": return amount * CAD_TO_UAH;
                case "USD": return amount * CAD_TO_USD;
                case "EUR": return amount * CAD_TO_EUR;
            }
        }
        return -1; //error
    }

}
