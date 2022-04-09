package middle.backtrack;

/**
 * No.36 有效的数独 (Microsoft)
 */
public class No_36 {
    public boolean isValidSudoku_new(char[][] board) {
        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boards = new boolean[9][9];

        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1';
                int boardNum = i / 3 * 3 + j / 3;
                if (rows[i][num] || cols[num][j] || boards[boardNum][num]) return false;
                rows[i][num] = true;
                cols[num][j] = true;
                boards[boardNum][num] = true;
            }
        }

        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i ++) {
            for (int j = 0; j < 9; j ++) {
                char ch = board[i][j];
                if (ch == '.') continue;
                if (!isValid(board, i, j)) return false;
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        for (int i = 0; i < 9; i ++) {
            if (i == row) continue;
            if (board[i][col] == board[row][col]) return false;
        }

        for (int j = 0; j < 9; j ++) {
            if (j == col) continue;
            if (board[row][j] == board[row][col]) return false;
        }

        for (int i = row / 3 * 3; i < row / 3 * 3 + 3; i ++) {
            for (int j = col / 3 * 3; j < col / 3 * 3 + 3; j ++) {
                if (i == row && j == col) continue;
                if (board[i][j] == board[row][col]) return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        double i = Math.sqrt(27);
        System.out.println(27 % i);
    }
}
