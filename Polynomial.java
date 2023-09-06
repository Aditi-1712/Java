import java.util.Arrays;

public final class Polynomial {
    int[] coefficient;

    private int[] data;
    private int degree;

    public Polynomial(int[] coefficient) {
        this.coefficient = normalize(coefficient);
        this.degree = this.coefficient.length - 1;

        int len = coefficient.length;
        data = new int[coefficient.length];
        for (int i = 0; i < coefficient.length; i++) {
            data[i] = coefficient[i];
        }
        for (int i = len - 1; i >= 0; i--) {
            if (data[i] != 0) {
                degree = i;
                break;
            }
        }
    }

    public int[] getCoefficient() {
        return Arrays.copyOf(coefficient, coefficient.length);
    }

    public int getCoefficient(int i) {
        if (i >= coefficient.length)
            return 0;
        return coefficient[i];
    }

    public int getDegree() {
        return degree;
    }

    public long evaluate(int x) {
        long result = 0;
        long term = 1;
        for (int i = 0; i < coefficient.length; i++) {
            result += term * coefficient[i];
            term *= x;
        }
        return result;
    }

    public Polynomial add(Polynomial p) {
        int[] c1 = this.coefficient;
        int[] c2 = p.getCoefficient();
        int max = Math.max(c1.length, c2.length);
        int min = Math.min(c1.length, c2.length);
        int[] c3Temp = new int[max];
        for (int i = 0; i < min; i++) {
            c3Temp[i] = c1[i] + c2[i];
        }
        for (int i = min; i < c1.length; i++) {
            c3Temp[i] = c1[i];
        }
        for (int i = min; i < c2.length; i++) {
            c3Temp[i] = c2[i];
        }
        return new Polynomial(normalize(c3Temp));
    }

    public Polynomial multiply(Polynomial p) {
        int[] c1 = this.coefficient;
        int[] c2 = p.getCoefficient();
        int[] c3Temp = new int[c1.length + c2.length - 1];
        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                c3Temp[i + j] += c1[i] * c2[j];
            }
        }

        return new Polynomial(normalize(c3Temp));
    }

    private int[] normalize(int[] c) {
        int d = 0;
        for (int i = 0; i < c.length; i++) {
            if (c[i] != 0) {
                d = i;
            }
        }
        int[] c2 = new int[d + 1];
        for (int i = 0; i <= d; i++) {
            c2[i] = c[i];
        }

        return c2;
    }

    @Override
    public String toString() {
        String eq = "";
        for (int i = 0; i < coefficient.length; i++) {
            if (i == 0) {
                eq += coefficient[0];
            } else if (i == 1) {
                if (coefficient[1] > 0) {
                    eq += "+" + coefficient[1] + "X";
                } else if (coefficient[1] < 0) {
                    eq += coefficient[1] + "X";
                }
            } else {
                if (coefficient[i] > 0) {
                    eq += "+" + coefficient[i] + "X^" + i;
                } else if (coefficient[i] < 0) {
                    eq += coefficient[i] + "X^" + i;
                }
            }
        }
        return eq;

    }



//        public Polynomial(int[] coefficients) {
//            int len = coefficients.length;
//            data = new int[coefficients.length];
//            for (int i = 0; i < coefficients.length; i++) {
//                data[i] = coefficients[i];
//            }
//            for (int i = len - 1; i >= 0; i--) {
//                if (data[i] != 0) {
//                    degree = i;
//                    break;
//                }
//            }
//        }

        public int evaluate(double x) {
            int sum = 0;
            for (int i = 0; i <= degree; i++) {
                sum = sum + data[i] * (int) Math.pow(x, i);
            }
            return sum;
        }




//        public Polynomial add(Polynomial other) {
//            int degree = Math.max(this.degree, other.degree);
//            int[] coefficients = new int[degree + 1];
//
//            for(int i = 0; i <= degree; i++) {
//                coefficients[i] = 0;
//
//                if(i <= this.degree)
//                    coefficients[i] = coefficients[i] + this.data[i];
//
//                if(i <= other.degree)
//                    coefficients[i] = coefficients[i] + other.data[i];
//            }
//
//            return new Polynomial(coefficients);
//        }




    }

