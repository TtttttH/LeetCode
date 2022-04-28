package middle.Math;

/**
 * No.48 旋转图像(middle) Microsoft
 */
public class No_48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n / 2; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }

        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n - i - 1; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][n - i - 1];
                matrix[n - j - 1][n - i - 1] = temp;
            }
        }
    }
}
