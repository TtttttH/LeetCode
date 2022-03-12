package hard.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No,37 解数独官方写法
 */
public class No_37_official {
    boolean[][] row = new boolean[9][9];
    boolean[][] column = new boolean[9][9];
    boolean[][][] blocks = new boolean[3][3][9];
    List<int[]> spaces = new ArrayList<>(); //record the space indexes
    boolean valid = false;

    public void solveSudoku(char[][] board) {
        //initialize the boolean arrays
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    spaces.add(new int[]{i, j});
                    continue;
                }

                int num = board[i][j] - '0' - 1;
                row[i][num] = true;
                column[num][j] = true;
                blocks[i / 3][j / 3][num] = true;
            }
        }

        backtrack(board, 0);
    }

    private void backtrack(char[][] board, int pos) {
        if (pos == spaces.size()) {
            valid = true;
            return;
        }
        int[] space = spaces.get(pos);
        int i = space[0], j = space[1];
        for (int num = 0; num < 9 && !valid; num++) { // notice that using valid to control the end of loop here.
            if (row[i][num] || column[num][j] || blocks[i / 3][j / 3][num]) continue;
            // meet all the criteria
            board[i][j] = (char) ('1' + num);
            row[i][num] = column[num][j] = blocks[i / 3][j / 3][num] = true;
            backtrack(board, pos + 1);
//            board[i][j] = '.';  can't let board[i][j] = '.' again
            row[i][num] = column[num][j] = blocks[i / 3][j / 3][num] = false;
        }
    }
}
