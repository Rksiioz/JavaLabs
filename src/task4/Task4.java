package task4;

public class Task4 {

    public static void main(String[] args) {
        String input = "a bulleT w/ my namE On";

        int[] charCount = new int[256];

        for (int i = 0; i < input.length(); i++) {
            charCount[input.charAt(i)]++;
        }

        CharCount[] symbolCounts = new CharCount[input.length()];
        int index = 0;

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                symbolCounts[index] = new CharCount((char) i, charCount[i]);
                System.out.println(symbolCounts[index]);
                index++;
            }
        }
    }

}
