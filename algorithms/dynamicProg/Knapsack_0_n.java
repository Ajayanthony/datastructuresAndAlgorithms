package dynamicProg;

/**
 * Given a knapsack weight W and a set of n items with certain value vali and weight wti, we need to calculate
 * minimum amount that could make up this quantity exactly. This is different from classical Knapsack problem,
 * here we are allowed to use unlimited number of instances of an item.
 * Examples:
 * Input : W = 100
 * val[]  = {1, 30}
 * wt[] = {1, 50}
 * Output : 100
 * There are many ways to fill knapsack.
 * 1) 2 instances of 50 unit weight item.
 * 2) 100 instances of 1 unit weight item.
 * 3) 1 instance of 50 unit weight item and 50
 * instances of 1 unit weight items.
 * We get maximum value with option 2.
 * Input : W = 8
 * val[] = {10, 40, 50, 70}
 * wt[]  = {1, 3, 4, 5}
 * Output : 110
 * We get maximum value with one unit of
 * weight 5 and one unit of weight 3.
 */
public class Knapsack_0_n {

    public static int getKnapsackValue(int[] val, int[] wt, int cap) {
        int valSum[] = new int[cap + 1];

        for (int i = 0; i < val.length; i++) {
            valSum[wt[i]] = val[i];
            for (int j = 1; j <= cap; j++) {
                if (valSum[j] != 0 && j + wt[i] <= cap) {
                    valSum[j + wt[i]] = Math.max(valSum[j + wt[i]], valSum[j] + val[i]);
                }
            }
        }
        int max = Integer.MIN_VALUE;

        for (int j = cap; j > 0; j--) {
            if (valSum[j] != 0) {
                max = valSum[j];
                break;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int val1[] = new int[]{1, 30};
        int wt1[] = new int[]{1, 50};
        System.out.println(getKnapsackValue(val1, wt1, 100));

        int val2[] = new int[]{10, 40, 50, 70};
        int wt2[] = new int[]{1, 3, 4, 5};
        System.out.println(getKnapsackValue(val2, wt2, 8));
    }
}
