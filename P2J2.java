import java.util.HashSet;
public class P2J2 {

    public static String removeDuplicates(String text){
        //throw new UnsupportedOperationException();

            StringBuilder result = new StringBuilder();

            int length = text.length();

            for (int i = 0; i < length; i++) {
                char currentChar = text.charAt(i);

                // Append the current character to the result if it's the first occurrence
                if (i == 0 || currentChar != text.charAt(i - 1)) {
                    result.append(currentChar);
                }
            }

            return result.toString();


    }

    public static String uniqueCharacters(String text){

        //throw new UnsupportedOperationException();

        //Two nested loops
        //outer loop iterating through the text
        //inner loop iterating through all the previous positions to check for the same characters.

        //Using hashset to make the process of removal of any extra characters easy


            StringBuilder result = new StringBuilder();
            HashSet<Character> seenCharacters = new HashSet<>();

            for (int i = 0; i < text.length(); i++) {
                char currentChar = text.charAt(i);

                // Check if the current character has been seen before
                if (!seenCharacters.contains(currentChar)) {
                    result.append(currentChar);
                    seenCharacters.add(currentChar);
                }
            }

            return result.toString();
        }



    public static int countSafeSquaresRooks(int n, boolean[][] rooks){
//        throw new UnsupportedOperationException();

        boolean[] safeRows = new boolean[n];
        boolean[] safeCols = new boolean[n];

        // Initialize all rows and columns as safe
        for (int i = 0; i < n; i++) {
            safeRows[i] = true;
            safeCols[i] = true;
        }

        // Mark unsafe rows and columns based on the positions of the rooks
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (rooks[i][j]) {
                    safeRows[i] = false;
                    safeCols[j] = false;
                }
            }
        }

        // Count the number of safe rows and columns
        int safeRowCount = 0;
        int safeColCount = 0;

        for (int i = 0; i < n; i++) {
            if (safeRows[i]) {
                safeRowCount++;
            }
            if (safeCols[i]) {
                safeColCount++;
            }
        }

        // Return the product of safe row count and safe column count
        return safeRowCount * safeColCount;
    }

    public static int recaman(int n){
//        throw new UnsupportedOperationException();

        int[] sequence = new int[n + 1];
        boolean[] isPresent = new boolean[10 * n];

        sequence[0] = 0;
        isPresent[0] = true;

        for (int i = 1; i <= n; i++) {
            int currentTerm = sequence[i - 1] - i;

            if (currentTerm < 0 || isPresent[currentTerm]) {
                currentTerm = sequence[i - 1] + i;
            }

            sequence[i] = currentTerm;
            isPresent[currentTerm] = true;
        }

        return sequence[n];
    }

}
