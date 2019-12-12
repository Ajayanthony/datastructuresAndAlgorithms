package dynamicProg;

/**
 * Write an efficient program to find the sum of contiguous subarray within a one-dimensional
 * array of numbers which has the largest sum.
 */
public class LargestSumContiguousSubArray {

    public static int getLargestSum_KadanesAlgo(int[] arr) {
        int maxCurrent = 0;
        int maxSum = 0;
        int start = 0;
        int end = 0;
        int ptr = 0;
        for (int i = 0; i < arr.length; i++) {
            maxCurrent = maxCurrent + arr[i];
            if (maxCurrent < 0) {
                maxCurrent = 0;
                ptr = i + 1;
            } else if (maxSum < maxCurrent) {
                maxSum = maxCurrent;
                start = ptr;
                end = i;
            }
        }

        System.out.println("Start:" + start + " end:" + end);
        return maxSum;
    }

    public static int getLargestSumWithNegativeNums(int[] arr) {
        int maxCurrent = arr[0];
        int maxSum = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            maxSum = Math.max(maxSum, maxCurrent);
        }

        return maxSum;
    }
}
