package dynamicProg;

import java.util.LinkedList;

/**
 * Given a grid of numbers, find maximum length Snake sequence and print it.
 * If multiple snake sequences exists with the maximum length, print any one of them.
 * <p>
 * A snake sequence is made up of adjacent numbers in the grid such that for each number,
 * the number on the right or the number below it is +1 or -1 its value.
 * For example, if you are at location (x, y) in the grid, you can either move right i.e. (x, y+1)
 * if that number is ± 1 or move down i.e. (x+1, y) if that number is ± 1.
 * <p>
 * For example,
 * <p>
 * 9, 6, 5, 2
 * 8, 7, 6, 5
 * 7, 3, 1, 6
 * 1, 1, 1, 7
 * <p>
 * In above grid, the longest snake sequence is: (9, 8, 7, 6, 5, 6, 7)
 */
public class SnakeSequence {

    public static void traverseSnakeSeq(int[][] grid) {
        int rows = grid.length;
        int ht = grid[0].length;
        int[][] pathLens = new int[rows + 1][ht + 1];
        int mx = -1;
        int my = -1;
        int maxLen = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < ht; j++) {
                int up = 0, left = 0;
                if ((i - 1) != -1 &&
                        Math.abs(grid[i - 1][j] - grid[i][j]) == 1) {
                    up = pathLens[i][j + 1] + 1;
                }

                if ((j - 1) != -1 &&
                        Math.abs(grid[i][j - 1] - grid[i][j]) == 1) {
                    left = pathLens[i + 1][j] + 1;
                }

                pathLens[i + 1][j + 1] = Math.max(up, left);
                if (maxLen < pathLens[i + 1][j + 1]) {
                    mx = i;
                    my = j;
                    maxLen = pathLens[i][j];
                }
            }
        }

        SnakeSequence.printSnakeSeq(pathLens, grid, mx, my);
    }

    private static void printSnakeSeq(int[][] pathLens, int[][] grid, int mx, int my) {
        LinkedList<Integer> stack = new LinkedList<>();

        int i = mx;
        int j = my;

        while (i >= 0 && j >= 0) {
            stack.push(grid[i][j]);
            if (pathLens[i][j + 1] == pathLens[i + 1][j + 1] - 1) {
                i--;
            } else if (pathLens[i + 1][j] == pathLens[i + 1][j + 1] - 1) {
                j--;
            } else break;
        }

        stack.stream()
                .forEach(x -> System.out.print(x + "  "));
    }

    public static void main(String[] args) {
        int[][] grid = {
                {9, 6, 5, 2},
                {8, 7, 6, 5},
                {7, 3, 1, 6},
                {1, 1, 1, 7}
        };

        SnakeSequence.traverseSnakeSeq(grid);
    }
}
