package middle.prefixSum;


/**
 * No.304 二维区域和检索-矩阵不可变 (Microsoft)
 */
public class No_304 {
    int[][] numMatrix;
    public No_304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        numMatrix = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i ++) {
            for (int j = 1; j <= n; j ++) {
                numMatrix[i][j] = numMatrix[i][j - 1] + numMatrix[i - 1][j] - numMatrix[i - 1][j - 1] + matrix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return numMatrix[row2 + 1][col2 + 1] + numMatrix[row1][col1] - numMatrix[row1][col2 + 1] - numMatrix[row2 + 1][col1];
    }
}
