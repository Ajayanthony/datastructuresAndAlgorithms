package matrix;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 */
public class SubMatrixCount {
    public static int countSquares(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                    int a = i + 1;
                    int b = j + 1;

                    while (a < matrix.length && b < matrix[0].length
                            && matrix[a][b] == 1) {
                        if (checkRow(matrix, a, j, b)
                                && checkCol(matrix, b, i, a)) {
                            count++;
                        } else {
                            break;
                        }
                        a++;
                        b++;
                    }
                }
            }
        }
        return count;
    }

    private static boolean checkCol(int[][] matrix, int col, int start, int end) {
        for (int i = start; i < end; i++) {
            if (matrix[i][col] == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRow(int[][] matrix, int row, int start, int end) {
        for (int i = start; i < end; i++) {
            if (matrix[row][i] == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSquares(
                new int[][]{
                        {0, 1, 1, 1},
                        {1, 1, 1, 1},
                        {0, 1, 1, 1}
                }
        )); //15

        System.out.println(countSquares(
                new int[][]{
                        {1, 0, 1},
                        {1, 1, 0},
                        {1, 1, 0}
                }
        )); //7
    }
}
