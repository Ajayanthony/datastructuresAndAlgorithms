package dynamicProg;

import java.util.Arrays;

public class MaxSumQuestions {

    /**
     * Given an array and a number k, find the largest sum of contiguous array in the modified array which is formed by
     * repeating the given array k times.
     * <p>
     * Examples :
     * Input  : arr[] = {-1, 10, 20}, k = 2
     * Output : 59
     * After concatenating array twice, we
     * get {-1, 10, 20, -1, 10, 20} which has
     * maximum subarray sum as 59.
     * <p>
     * Input  : arr[] = {-1, -2, -3}, k = 3
     * Output : -1
     */
    public static int getMaxSumArrayRepeatedConcat(int[] arr, int k) {
        //Answer is maximum sum subarray from doubled arr plus either 0 or K−2 sums of all elements in arr.
        int[] arrDoubled = new int[arr.length * 2];

        for (int i = 0; i < arr.length * 2; i++) {
            arrDoubled[i] = arr[i % arr.length];
        }
        System.out.println(Arrays.toString(arrDoubled));
        int sum = LargestSumContiguousSubArray.getLargestSumWithNegativeNums(arrDoubled);
        int arrSum = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSum = arrSum + arr[i];
        }

        if (arrSum > 0 && k > 2) {
            sum = sum + (arrSum * (k - 2));
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{-1, 10, 20};
        int[] arr2 = new int[]{-1, -2, -3};
        System.out.println(getMaxSumArrayRepeatedConcat(arr1, 2));
        System.out.println(getMaxSumArrayRepeatedConcat(arr2, 3));
    }
}
