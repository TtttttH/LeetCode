package easy;

/**
 * No.661 图片平滑器
 */
public class No_661 {
    public int[][] imageSmoother(int[][] img) {
        int[][] dirs = {{0,1}, {0,-1}, {1,0}, {-1,0}, {1,-1}, {1,1}, {-1,1}, {-1,-1}};
        int m = img.length;
        int n = img[0].length;
        int[][] rebuild = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j ++) {
                int sum = img[i][j], count = 1;
                for (int[] dir : dirs) {
                    int a = i + dir[0], b = j + dir[1];
                    if (a < 0 || a >= m || b < 0 || b >= n) continue;
                    count ++;
                    sum += img[a][b];
                }
                rebuild[i][j] = sum / count;
            }
        }
        return rebuild;
    }
}
