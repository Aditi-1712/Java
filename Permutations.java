import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Permutations {
    public static int[] chain(int[] p1, int[] p2) {
        int n = p1.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = p1[p2[i]];
        }
        return p;
    }

    public static int[] inverse(int[] perm) {
        int n = perm.length;
        int[] inverse = new int[n];
        for (int i = 0; i < n; i++) {
            inverse[perm[i]] = i;
        }
        return inverse;
    }

    public static int[] square(int[] perm) {
        return chain(perm, perm);
    }

    public static int[] power(int[] perm, int k) {
        int n = perm.length;
        if (k == 0) {
            int[] identityPerm = new int[n];
            for (int i = 0; i < n; i++) {
                identityPerm[i] = i;
            }
            return identityPerm;
        } else if (k == 1) {
            return Arrays.copyOf(perm, n);
        } else if (k == 2) {
            return square(perm);
        } else if (k > 0) {
            int[] halfPower = power(perm, k / 2);
            if (k % 2 == 0) {
                return square(halfPower);
            } else {
                return chain(perm, square(halfPower));
            }
        } else {
            int[] inversePerm = inverse(perm);
            return power(inversePerm, -k);
        }
    }

}
