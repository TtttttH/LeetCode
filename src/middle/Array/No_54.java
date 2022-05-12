package middle.Array;

import java.util.ArrayList;
import java.util.List;

/**
 * No.54 螺旋矩阵 TODO
 */
public class No_54 {
    public List<Integer> spiralOrder (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int offset = 0;
        int loop = Math.min(m, n) / 2;
        while (loop > 0) {
            for (int j = offset; j < n - offset; j ++) {
                res.add(matrix[offset][j]);
            }

            for (int i = offset + 1; i < m - offset; i ++) {
                res.add(matrix[i][n - offset - 1]);
            }

            for (int j = n - offset - 2; j >= offset; j --) {
                res.add(matrix[m - offset - 1][j]);
            }

            for (int i = n - offset - 2; i > offset; i --) {
                res.add(matrix[i][offset]);
            }

            loop --;
            offset ++;
        }

        if (Math.min(m, n) % 2 == 1) {
            if (m > n) {
                for (int i = offset; i < m - offset; i ++) {
                    res.add(matrix[i][offset]);
                }
            } else {
                for (int j = offset; j < n - offset; j ++) {
                    res.add(matrix[offset][j]);
                }
            }
        }

        return res;
    }
}
