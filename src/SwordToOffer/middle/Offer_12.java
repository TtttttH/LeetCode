package SwordToOffer.middle;

public class Offer_12 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (dfs(board, word, i, j, 0, visited)) return true;
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int k, boolean[][] visited) {
        if (k == word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || board[i][j] != word.charAt(k)) return false;
        visited[i][j] = true;
        boolean result = dfs(board, word, i - 1, 1, k + 1, visited)
                || dfs(board, word, i + 1, 1, k + 1, visited)
                || dfs(board, word, i, j - 1, k + 1, visited)
                || dfs(board, word, i, j + 1, k + 1, visited);
        visited[i][j] = false;
        return result;
    }
}
