package dynamicProg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array A of integers, return the length
 * of the longest arithmetic subsequence in A.
 * <p>
 * Input: [9,4,7,2,10]
 * Output: 3
 * Explanation:
 * The longest arithmetic subsequence is [4,7,10].
 * <p>
 * Input: [20,1,15,3,10,5,8]
 * Output: 4
 * Explanation:
 * The longest arithmetic subsequence is [20,15,10,5].
 */
public class LongestArithSeqLength {

    public static int getLongestSeqLength(int[] A) {
        List<Map<Integer, Integer>> diffs = new ArrayList<>();
        int max = 1;
        for (int i = 0; i < A.length; i++) {
            diffs.add(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                if (diffs.get(j).containsKey(diff)) {
                    int temp = diffs.get(j).get(diff) + 1;
                    diffs.get(i).put(diff, temp);
                    if (max < temp) max = temp;
                } else {
                    diffs.get(i).put(diff, 1);
                }
            }
        }

        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(getLongestSeqLength(
                new int[]{83, 20, 17, 43, 52, 78, 68, 45}
        ));

//        System.out.println(getLongestSeqLength(
//                new int[]{20, 1, 15, 3, 10, 5, 8}
//        ));
    }
}
