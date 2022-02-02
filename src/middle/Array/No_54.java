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
        int startx = 0;
        int starty = 0;
        int offset = 1;
        int loop = Math.min(m, n) / 2;
        int count = 0;
        while (loop > 0) {
            int i = startx;
            int j = starty;
            for (; j < n - offset; j ++) {
                res.add(matrix[startx][j]);
            }

            for (; i < m - offset; i ++) {
                res.add (matrix[i][j]);
            }

            for (; j > starty; j --) {
                res.add(matrix[i][j]);
            }

            for (; i > startx; i ++) {
                res.add(matrix[i][j]);
            }
        }

        return res;
    }
}
