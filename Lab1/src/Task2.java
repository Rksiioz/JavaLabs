public class Task2 {


    public static void main(String[] args) {
        String[] expressions = {
                "2 + 2 = ?",
                "5 - 1 =",
                "3 * 2",
                "4 / 2",
                "5 / 0",
                "7 ^ 2",
                "7 % 2"
        };

        for (String expression : expressions) {
            try {
                double result = evaluateExpression(expression);
                System.out.println("Вираз: " + expression + " Результат: " + result);
            } catch (Exception e) {
                System.out.println("Вираз: " + expression + " Помилка: " + e.getMessage());
            }
        }
    }

    private static double evaluateExpression(String input) throws Exception {
        input = input.replaceAll("= \\?|=$", "").trim(); // Видалення '= ?' і '='
        String[] tokens = input.split(" "); // 3 + 4 = ? --> [0] = 3, [1] = +...

        if (tokens.length != 3) throw new Exception("Некоректний вираз."); // після видалення символів має залишитися тільки 2 числа і оператор

        double num1 = Double.parseDouble(tokens[0]);
        double num2 = Double.parseDouble(tokens[2]);
        String operator = tokens[1];

        switch (operator) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "*": return num1 * num2;
            case "/":
                if (num2 == 0) throw new Exception("ділення на нуль");
                return num1 / num2;
            default: throw new Exception("Невідома операція: " + operator);
        }
    }
}
