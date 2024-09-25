package task4;

public class Task4 {

    public static void main(String[] args) {
        String songName = "a bulleT w/ my namE On";
        CharCount[] charCounts = countCharacters(songName);

        for (CharCount charCount : charCounts) {
            if (charCount != null) {
                System.out.println(charCount);
            }
        }
    }

    public static CharCount[] countCharacters(String input) {
        CharCount[] counts = new CharCount[256];  // масив для зберігання символів
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (counts[c] == null) {
                counts[c] = new CharCount(c, 1);  // символ зустрівся вперше
            } else {
                counts[c].count++;  // якщо символ вже зустрічався
            }
        }
        return counts;
    }
}
