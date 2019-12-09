package dynamicProg;

import java.util.Arrays;

/**
 * The Golomb sequence is a non-decreasing integer sequence where n-th term is equal to number of times n appears
 * in the sequence.
 * <p>
 * The first few values are
 * 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, …
 * <p>
 * Given a positive integer n. The task is to find the first n terms of Golomb sequence.
 */
public class GolombSequence {

    public static void printGolombSeq(int n) {
        int arr[] = new int[n + 1];
        arr[1] = 1;
        arr[2] = 2;
        int ptr = 2;

        for (int i = 2; i <= n && ptr <= n; i++) {
            for (int k = 0; k < arr[i] && ptr <= n; k++) {
                arr[ptr] = i;
                ptr++;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        GolombSequence.printGolombSeq(11);
    }
}
