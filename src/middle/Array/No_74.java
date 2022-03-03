package middle.Array;

/**
 * No.74 搜索二维矩阵
 */
public class No_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = matrix[mid / n][mid % n];
            if (val == target) return true;
            else if (val < target) left = mid + 1;
            else right = mid - 1;
        }

        return matrix[left / n][left % n] == target;
//        if (matrix == null || matrix.length == 0) return false;
//        int rowLen = matrix.length;
//        int colLen = matrix[0].length;
//        int row = rowLen - 1;
//        int col = 0;
//        while (row >= 0 && col < colLen) {
//            int val = matrix[row][col];
//            if (val == target) return true;
//            else if (val < target) {
//                col ++;
//            } else {
//                row --;
//            }
//        }
//
//        return false;
    }
}
