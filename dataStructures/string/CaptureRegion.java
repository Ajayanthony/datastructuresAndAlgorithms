package string;

/**
 * Given a 2D board containing ‘X’ and ‘O’, capture all regions surrounded by ‘X’.
 * A region is captured by flipping all ‘O’s into ‘X’s in that surrounded region .
 * The elements not surrounded by ‘X’ means that exists a path of
 * elements ‘O’ to a border.
 */
public class CaptureRegion {

    public static void convertXtoO(char[][] input) {
        char[][] result = new char[input.length][input[0].length];


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
