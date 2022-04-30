package middle.Array;

/**
 * No.73 矩阵置零 （Microsoft)
 */
public class No_73 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean rowFlag = false, colFlag = false;
        for (int i = 0; i < n; i ++) {
            if (matrix[0][i] == 0) {
                rowFlag = true;
                break;
            }
        }

        for (int i = 0; i < m; i ++) {
            if (matrix[i][0] == 0) {
                colFlag = true;
                break;
            }
        }

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i ++) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < n; j ++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < n; j ++) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < m; i ++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (rowFlag) {
            for (int i = 0; i < n; i ++) {
                matrix[0][i] = 0;
            }
        }

        if (colFlag) {
            for (int i = 0; i < m; i ++) {
                matrix[i][0] = 0;
            }
        }
    }
}