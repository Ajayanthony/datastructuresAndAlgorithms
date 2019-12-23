package string;

/**
 * Given a 2D board containing ‘X’ and ‘O’, capture all regions surrounded by ‘X’.
 * A region is captured by flipping all ‘O’s into ‘X’s in that surrounded region .
 */
public class ConvertXtoO_2D {

    /**
     * Converts the 2D matrix in place, but affects the input matrix reference.
     * Similar algo can be applied on a copy matrix to avoid affecting the input reference.
     *
     * @param input
     */
    public static void convertXtoO(char[][] input) {

        for (int i = 1; i < input.length - 1; i++) {
            for (int j = 1; j < input[0].length - 1; j++) {
                if (input[i][j] == 'O') {
                    if (input[i - 1][j - 1] == 'X'
                            && input[i - 1][j] == 'X'
                            && input[i - 1][j + 1] == 'X'
                            && input[i][j - 1] == 'X'
                            && input[i][j + 1] == 'X'
                            && input[i + 1][j - 1] == 'X'
                            && input[i + 1][j] == 'X'
                            && input[i + 1][j + 1] == 'X'
                    ) {
                        input[i][j] = 'Y';
                    }
                }
            }
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (input[i][j] == 'Y')
                    input[i][j] = 'X';
                System.out.print(Character.valueOf(input[i][j]));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        convertXtoO(new char[][]{
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        });
    }
}
