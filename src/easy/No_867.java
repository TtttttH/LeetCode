package easy;


/**
 * No.867 转置矩阵 (Microsoft)
 */
public class No_867 {
    public static int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < m; j ++) {
                res[i][j] = matrix[j][i];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] matrix= {{1,2,3},{4,5,6}};
        No_867.transpose(matrix);
    }
}
