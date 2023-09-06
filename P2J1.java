public class P2J1 {

    //passed the test
    public static long fallingPower(int n, int k) {
//        throw new UnsupportedOperationException();

        long result = 1;
        for(int i=0; i < k; i++){
            result = result * (n-i);
        }
return result;

}

//passed the test
    public static int[] everyOther(int[] arr){
//        throw new UnsupportedOperationException();
        int[] result = new int[arr.length / 2 + arr.length % 2];
        for (int i=0; i < result.length; i++){
            result[i] = arr[2 * i];
        }
        return result;

    }

    public static int[][] createZigZag(int rows, int cols, int start){
        //throw new UnsupportedOperationException();
        //making a 2D table into a zigzag thing
        //use the formula  start, start+1, ... , start+(rows*cols-1)..

        int[][] result = new int[rows][cols];
        int value = start;

        for (int i=0; i < rows; i++){
            if(i % 2 == 0){
                for (int j = 0; j < cols; j++){
                    result[i][j] = value++;
                }
            }

            else {
                for ( int j = cols-1; j >= 0; j--){
                    result[i][j] = value++;
                }
            }
        }
        return result;
    }

    public static int countInversions(int[] arr){
//        throw new UnsupportedOperationException();

            int count = 0;
            for (int i = 0; i < arr.length - 1; i++) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[i] > arr[j]) {
                        count++;
                    }
                }
            }
            return count;
        }


}
