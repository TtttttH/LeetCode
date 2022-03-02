package SwordToOffer.middle;

/**
 * 剑指offer 04 二维数组的查找
 */
public class Offer_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int row = 0, col = colLen - 1;
        while (row < rowLen && col >= 0) {
            int val = matrix[row][col];
            if (val == target) return true;
            else if (val < target) {
                row ++;
            } else {
                col --;
            }
        }

        return false;
    }
}
