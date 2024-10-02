public class Task5 {

    public static void main(String[] arg) {
        String[][] matrix = {
                {"Roshan", "Drow Ranger", "Juggernaut"},
                {"Marci", "roshan", "Void Spirit"},
                {"Pangolier", "Roshan", "Ros han"}
        };

        String substring = "Roshan";
        int count = countSubstring(matrix, substring);
        System.out.println("Кількість входжень: " + count);
    }

    public static int countSubstring(String[][] matrix, String substring) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].contains(substring)) {
                    count++;
                }
            }
        }

        return count;
    }
}
