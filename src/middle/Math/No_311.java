package middle.Math;

/**
 * No.311 稀疏矩阵的乘法
 */
public class No_311 {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int m1 = mat1.length;
        int n1 = mat1[0].length;
        int m2 = mat2.length;
        int n2 = mat2[0].length;
        if (n1 != m2) return null;

        int[][] res = new int[m1][n2];
        for (int i = 0; i < m1; i ++) {
            for (int c = 0; c < n1; c ++) {
                if (mat1[i][c] == 0) continue;
                for (int j = 0; j < n2; j ++) {
                    res[i][j] += mat1[i][c] * mat2[c][j];
                }
            }
        }
        return res;
//        boolean[] notNull1 = new boolean[m1];
//        boolean[] notNull2 = new boolean[n2];
//        for (int i = 0; i < m1; i ++) {
//            for (int num : mat1[i]) {
//                if (num != 0) {
//                    notNull1[i] = true;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < n2; i ++) {
//            for (int j = 0; j < m2; j ++) {
//                if (mat2[j][i] != 0) {
//                    notNull2[i] = true;
//                    break;
//                }
//            }
//        }
//
//        for (int i = 0; i < m1; i ++) {
//            for (int j = 0; j < n2; j ++) {
//                if (notNull1[i] && notNull2[j]) {
//                    for (int k = 0; k < n1; k ++) {
//                        res[i][j] += mat1[i][k] * mat2[k][j];
//                    }
//                }
//            }
//        }
//
//        return res;
    }
}
