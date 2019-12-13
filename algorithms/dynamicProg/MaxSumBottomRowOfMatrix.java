package dynamicProg;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Given a matrix of integers where every element represents weight of the cell.
 * Find the path having the maximum weight in matrix [N X N]. Path Traversal Rules are:
 * It should begin from top left element.
 * The path can end at any element of last row.
 * We can move to following two cells from a cell (i, j).
 * Down Move : (i+1, j)
 * Diagonal Move : (i+1, j+1)
 * <p>
 * Examples:
 * <p>
 * Input : N = 5
 * mat[5][5] = {{ 4, 2 ,3 ,4 ,1 },
 * { 2 , 9 ,1 ,10 ,5 },
 * {15, 1 ,3 , 0 ,20 },
 * {16 ,92, 41, 44 ,1},
 * {8, 142, 6, 4, 8} };
 * Output : 255
 * Path with max weight : 4 + 2 +15 + 92 + 142 = 255
 */
public class MaxSumBottomRowOfMatrix {

    public static void getMaxSumAtBottomRow(int[][] mtx) {
        int i = mtx.length;
        int j = mtx[0].length;
        int[][] sum = new int[i + 1][j + 1];
        int col = 0;
        int max = Integer.MIN_VALUE;
        for (int x = 1; x < i + 1; x++) {
            for (int y = 1; y < j + 1; y++) {
                sum[x][y] = Math.max(sum[x - 1][y], sum[x - 1][y - 1])
                        + mtx[x - 1][y - 1];
                if (x == i && max < sum[x][y]) {
                    max = sum[x][y];
                    col = y;
                }
            }
        }
//        Arrays.stream(sum)
//                .map(x -> Arrays.toString(x))
//                .forEach(System.out::println);

        System.out.println("Max Sum:" + max + " Location:" + i + "," + col);
        printPath(mtx, sum, col - 1);
    }

    private static void printPath(int[][] mtx, int[][] sum, int col) {
        LinkedList<Integer> stack = new LinkedList<>();

        int i = mtx.length - 1;
        int j = col;

        while (i != 0 || j != 0) {
            stack.push(mtx[i][j]);
            if (sum[i][j] < sum[i][j + 1]) {
                i--;
            } else {
                i--;
                j--;
            }
        }
        System.out.print(mtx[0][0] + ", ");

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + ", ");
        }
    }

    public static void main(String[] args) {
        int[][] mat = {{4, 2, 3, 4, 1},
                {2, 9, 1, 10, 5},
                {15, 1, 3, 0, 20},
                {16, 92, 41, 44, 1},
                {8, 142, 6, 4, 8}};

        getMaxSumAtBottomRow(mat);
    }
}
