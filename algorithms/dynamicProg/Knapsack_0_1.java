package dynamicProg;

/**
 * Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in
 * the knapsack. In other words, given two integer arrays val[0..n-1] and wt[0..n-1] which represent values and weights
 * associated with n items respectively. Also given an integer W which represents knapsack capacity, find out the
 * maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).
 */
public class Knapsack_0_1 {

    /**
     * This solution does not create a matrix for calculations.
     * Instead it uses an array and parses it from end to start, updating the vals if weight within cap.
     */
    public static int getKnapsackValue(int[] vals, int[] wts, int cap) {
        int[] totalVal = new int[cap + 1];
        int result = 0;
        for (int i = 0; i < vals.length; i++) {
            for (int j = cap; j >= 0; j--) {
                if (totalVal[j] != 0 || j == 0) {
                    if (j + wts[i] <= cap) {
                        totalVal[j + wts[i]] = Math.max(totalVal[j + wts[i]],
                                totalVal[j] + vals[i]);
                    }
                }
            }
        }

        if (totalVal[cap] == 0) {
            for (int j = cap; j >= 0; j--) {
                if (totalVal[j] != 0) {
                    result = totalVal[j];
                    break;
                }
            }
        } else {
            result = totalVal[cap];
        }

        return result;
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int W = 50;
        System.out.println(getKnapsackValue(val, wt, W));
    }
}
