import java.lang.Math;
import java.math.BigInteger;
import java.io.*;
import java.math.*;
public class P2J8 {


    public static void hittingIntegerPowers(int a, int b, int t, int[] out) {

        BigInteger aa = new BigInteger(a + ""); // multiplier a

        BigInteger bb = new BigInteger(b + ""); // multiplier b

        BigInteger n1 = new BigInteger(a + ""); // a^pa

        BigInteger n2 = new BigInteger(b + ""); // b^ppb

        BigInteger tt = new BigInteger(t + ""); // multiplier t

        int pa = 1, pb = 1; // initial powers

        while (true) {

            BigInteger diff = n1.subtract(n2).abs().multiply(tt); // check product of difference

            if (diff.compareTo(n1) <= 0 || diff.compareTo(n2) <= 0) {

                out[0] = pa;

                out[1] = pb;

                return;

            }

            if (n1.compareTo(n2) <= 0) { // increase power of smaller number

                n1 = n1.multiply(aa);

                pa++;

            } else {

                n2 = n2.multiply(bb);

                pb++;

            }


        }
    }

    static BigInteger sGonal(BigInteger i, int s) {
        BigInteger ans = i.multiply(i);
        ans = ans.multiply(BigInteger.valueOf(s - 2));
        BigInteger temp = i.multiply(BigInteger.valueOf(s - 4));
        ans = ans.subtract(temp);
        return ans.divide(BigInteger.valueOf(2));}


        public static BigInteger nearestPolygonalNumber (BigInteger n,int s){
            BigInteger TWO = BigInteger.valueOf(2);
            BigInteger TEN = BigInteger.valueOf(10);
            BigInteger ONE = BigInteger.valueOf(1);
            BigInteger b = BigInteger.valueOf(1);
            while (sGonal(b, s).compareTo(n) == -1) {
                b = b.multiply(TEN);
            }
            BigInteger a = b.divide(TEN);
            while (a.compareTo(b) < 0) {
                BigInteger mid = a.add(b).divide(TWO);
                BigInteger val = sGonal(mid, s);
                if (val.compareTo(n) == 0) return val;
                if (val.compareTo(n) == -1) a = mid.add(ONE);
                else b = mid;
            }
            if (a.compareTo(b) == 0) {
                a = a.subtract(ONE);
            }
            BigInteger first = n.subtract(sGonal(a, s)).abs();
            BigInteger second = n.subtract(sGonal(b, s)).abs();
            if (first.compareTo(second) <= 0) return sGonal(a, s);
            return sGonal(b, s);
        }


    }

