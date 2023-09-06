import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class P2J4 {

    public static List<Integer> runningMedianOfThree(List<Integer> items) {
        //first two elements of the list will remain the same
        //new list will have the medians of the three elements

            List<Integer> newArr = new ArrayList<>();

            if (items.size() <= 2) {
                return items;
            }

            // Add the first two elements as they are to the result list
            newArr.add(items.get(0));
            newArr.add(items.get(1));

            for (int i = 2; i < items.size(); i++) {
                int median = getMedian(items.get(i - 2), items.get(i - 1), items.get(i));
                newArr.add(median);
            }

            return newArr;
        }






        private static int getMedian(int a, int b, int c) {
            int[] arr = { a, b, c };
            // Sort the array in ascending order
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (arr[j] < arr[i]) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }

            // The median will be the middle element
            return arr[1];
        }



    public static int firstMissingPositive(List<Integer> items){



            int n = items.size();
            boolean[] seen = new boolean[n + 2]; // We need n+2 elements to cover 1 to n+1 range

            // Mark seen numbers in the boolean array
            for (int num : items) {
                if (num > 0 && num <= n + 1) {
                    seen[num] = true;
                }
            }

            // Find the first missing positive number
            for (int i = 1; i <= n + 1; i++) {
                if (!seen[i]) {
                    return i;
                }
            }

            return 1; // Default case if all positive numbers are present
        }


    public static void sortByElementFrequency(List<Integer> items) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Build the frequency map
        for (int item : items) {
            frequencyMap.put(item, frequencyMap.getOrDefault(item, 0) + 1);
        }

        // Define the comparator for sorting by frequency and value
        Comparator<Integer> frequencyComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                int frequencyComparison = Integer.compare(frequencyMap.get(b), frequencyMap.get(a));

                if (frequencyComparison != 0) {
                    return frequencyComparison;
                } else {
                    return Integer.compare(a, b);
                }
            }
        };

        // Sort the items list using the frequency comparator
        Collections.sort(items, frequencyComparator);
    }




    public static List<Integer> factorFactorial(int n) {
        List<Integer> factors = new ArrayList<>();

        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                int count = countPrimeFactors(n, i);
                for (int j = 0; j < count; j++) {
                    factors.add(i);
                }
            }
        }

        return factors;
    }

    private static boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    private static int countPrimeFactors(int num, int prime) {
        int count = 0;

        while (num > 0) {
            num /= prime;
            count += num;
        }

        return count;
    }



}
