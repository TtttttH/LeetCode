package middle.backtrack;

/**
 * No.79 单词搜索(middle) 微软
 */
public class No_79 {
    int[][] dire = {{0, 1}, {0, -1}, {1, 0},{-1, 0}};
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i ++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (backtrack(board, visited, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, boolean [][] visited, String word, int k, int curRow, int curCol) {
        if (board[curRow][curCol] != word.charAt(k)) return false;
        if (k == word.length() - 1) return true;
        visited[curRow][curCol] = true;
        for(int[] dir : dire) {
            int nextRow = curRow + dir[0];
            int nextCol = curCol + dir[1];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && !visited[nextRow][nextCol]) {
                if (backtrack(board, visited, word,k + 1,  nextRow, nextCol)) return true;
            }
        }
        visited[curRow][curCol] = false;
        return false;
    }
}
