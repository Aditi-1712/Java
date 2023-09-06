import java.util.Arrays;

public class P2J9 {
    public static boolean[] sumOfTwoDistinctSquares(int n) {
        boolean[] result = new boolean[n];

        for (int a = 1; a * a < n; a++) {
            for (int b = a + 1; b * b < n; b++) {
                int sum = a * a + b * b;
                if (sum < n) {
                    result[sum] = true;
                }
            }
        }

        return result;
    }

    public static boolean[] subtractSquare(int n) {
        boolean[] result = new boolean[n + 1];
        result[0] = false; // Base case: n = 0 is cold

        for (int i = 1; i <= n; i++) {
            result[i] = false; // Assume the state is cold by default
            for (int j = 1; j * j <= i; j++) {
                if (!result[i - j * j]) {
                    // If there exists a winning move to a cold state, mark this state as hot
                    result[i] = true;
                    break;
                }
            }
        }

        return result;
    }

}
