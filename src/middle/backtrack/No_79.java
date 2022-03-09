package middle.backtrack;

/**
 * No.79 单词搜索(middle) 微软
 */
public class No_79 {
    boolean find = false;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                backtrack(board, visited, word, i, j, 0);
            }
        }

        return find;
    }

    private void backtrack(char[][] board, boolean[][] visited, String s, int i, int j, int idx) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] || find || board[i][j] != s.charAt(idx)) return;
        if (idx == s.length() - 1) {
            find = true;
            return;
        }

        visited[i][j] = true;
        backtrack(board, visited, s, i + 1, j, idx + 1);
        backtrack(board, visited, s, i, j + 1, idx + 1);
        backtrack(board, visited, s, i , j - 1, idx + 1);
        backtrack(board, visited, s, i - 1, j, idx + 1);
        visited[i][j] = false;
    }
}
