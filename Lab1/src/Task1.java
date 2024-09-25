public class Task1 {

    public static void main(String[] args) {
        int number = 22;

        String binary = toBinary(number);

        if (binary.equals("")) {
            System.out.println("Число = 0");
        } else {
            System.out.println("Число " + number + " в двійковій системі: " + binary);
        }

    }

    public static String toBinary(int number) {
        StringBuilder binaryNumber = new StringBuilder();

        while (number > 0) {
            int remainder = number % 2;
            binaryNumber.insert( 0, remainder);
            number = number / 2;
        }

        return binaryNumber.toString();
    }
}

