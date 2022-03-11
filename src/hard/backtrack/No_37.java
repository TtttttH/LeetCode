package hard.backtrack;

/**
 * No.37 解数独
 */
public class No_37 {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }

    private boolean backtrack(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] != '.') continue;
                for (char k = '1'; k <= '9'; k ++) {
                    if (isValid(board, i, j, k)) {
                        board[i][j] = k;
                        if (backtrack(board)) return true; //找到合适的情况，直接返回true
                        board[i][j] = '.';
                    }
                }
                return false; //如果board[i][j] 没有合适的值能够完成整个递归，返回FALSE；
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, int k) {
        for (int i = 0; i < 9; i ++) {
            if (board[i][col] == k) return false;
        }
        for (int j = 0; j < 9; j ++) {
            if (board[row][j] == k) return false;
        }

        for (int i = row / 3 * 3; i < (row / 3 + 1) * 3; i ++) {
            for (int j = col / 3 * 3; j < (col / 3 + 1) * 3; j ++) {
                if (board[i][j] == k) return false;
            }
        }

        return true;
    }
}
