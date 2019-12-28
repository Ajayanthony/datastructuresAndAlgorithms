package matrix;

/**
 * Given an integer matrix, find the length of the longest increasing path.
 * <p>
 * From each cell, you can either move to four directions: left, right, up or down.
 * You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).
 */
public class LongestIncreasingPath {
    private static int max = 0;

    public static void main(String[] args) {
        System.out.println(longestIncreasingPath(
                new int[][]{{1}}
        ));
    }

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int[][] pathLen = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pathLen[i][j] == 0) {
                    pathLen[i][j] = 1;
                    checkNeighbours(i, j, pathLen, matrix);
                }
            }
        }

        return max;
    }

    private static void checkNeighbours(int i, int j, int[][] pathLen, int[][] matrix) {
        if (max < pathLen[i][j]) max = pathLen[i][j];

        if (j < matrix[0].length - 1
                && matrix[i][j] < matrix[i][j + 1]
                && pathLen[i][j + 1] < pathLen[i][j] + 1) {
            pathLen[i][j + 1] = pathLen[i][j] + 1;
            checkNeighbours(i, j + 1, pathLen, matrix);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]
                && pathLen[i][j - 1] < pathLen[i][j] + 1) {
            pathLen[i][j - 1] = pathLen[i][j] + 1;
            checkNeighbours(i, j - 1, pathLen, matrix);
        }
        if (i < matrix.length - 1
                && matrix[i][j] < matrix[i + 1][j]
                && pathLen[i + 1][j] < pathLen[i][j] + 1) {
            pathLen[i + 1][j] = pathLen[i][j] + 1;
            checkNeighbours(i + 1, j, pathLen, matrix);
        }
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]
                && pathLen[i - 1][j] < pathLen[i][j] + 1) {
            pathLen[i - 1][j] = pathLen[i][j] + 1;
            checkNeighbours(i - 1, j, pathLen, matrix);
        }
    }
}
