package middle.Array;

/**
 * No.59 螺旋矩阵 two
 */
public class No_59 {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return null;
        }

        int[][] res = new int[n][n];
        int startx = 0;
        int starty = 0;
        int loop = n/2;
        int offset = 1;
        int count = 1;
        int mid = n/2;

        while (loop > 0) {
            loop --;
            int j = starty;
            int i = startx;
            for (; j < n - offset; j ++) {
                res[startx][j] = count ++;
            }

            for (; i < n - offset; i ++) {
                res[i][j] = count ++;
            }

            for(; j > offset; j --) {
                res[i][j] = count ++;
            }

            for(; i > offset; i --) {
                res[i][starty] = count ++;
            }

            startx ++;
            starty ++;
            offset ++;
        }

        if (n % 2 != 0) {
            res[mid][mid] = n * n;
        }

        return res;
    }
}
