package dynamicProg;

import java.util.Arrays;

public class MaxSumPairs {

    /**
     * Given an array of integers and a number k. We can pair two number of array if difference between
     * them is strictly less than k. The task is to find maximum possible sum of disjoint pairs.
     * Sum of P pairs is sum of all 2P numbers of pairs.
     * <p>
     * Examples:
     * Input  : arr[] = {3, 5, 10, 15, 17, 12, 9}, K = 4
     * Output : 62
     * Then disjoint pairs with difference less than K are,
     * (3, 5), (10, 12), (15, 17)
     * So maximum sum which we can get is 3 + 5 + 12 + 10 + 15 + 17 = 62
     * Note that an alternate way to form disjoint pairs is,
     * (3, 5), (9, 12), (15, 17), but this pairing produces lesser sum.
     * <p>
     * Input  : arr[] = {5, 15, 10, 300}, k = 12
     * Output : 25
     */
    public static int getMaxSumPairsWithDifference(int[] arr, int k) {
        Arrays.sort(arr);

        int[] sums = new int[arr.length + 1];
        sums[1] = arr[0] + arr[1];
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] < k)
                sums[i] = Math.max(sums[i - 2] + arr[i - 1] + arr[i], sums[i - 1]);
            else
                sums[i] = sums[i - 1];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(sums));
        return sums[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(getMaxSumPairsWithDifference(new int[]{3, 5, 10, 15, 17, 12, 9}, 4));
    }
}
