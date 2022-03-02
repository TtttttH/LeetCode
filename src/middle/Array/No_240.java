package middle.Array;

/**
 * No.240 搜索二维矩阵II
 */
public class No_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int row = 0, col = n - 1;
        while (row < m && col >= 0) {
            int val = matrix[row][col];
            if (val == target) return true;
            if (val < target) row ++;
            else col --;
        }

        return false;
    }
}
