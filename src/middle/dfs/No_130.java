package middle.dfs;

/**
 * No.130 被围绕的取余
 */
public class No_130 {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i ++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }

        for (int j = 1; j < n - 1; j ++) {
            dfs(board,0, j);
            dfs(board, m - 1, j);
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if (board[i][j] == '-') board[i][j] = 'O';
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i>= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] ==  'O') {
            board[i][j] = '-';
            dfs(board, i + 1, j);
            dfs(board, i - 1, j);
            dfs(board, i, j + 1);
            dfs(board, i, j - 1);
        }
    }
}
