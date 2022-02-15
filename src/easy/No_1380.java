package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.1380 Lucky Numbers in a Matrix
 */
public class No_1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int[] row = new int[rowLen];
        int[] col = new int[colLen];
        List<Integer> result = new ArrayList<>();
        for (int i = 0;i < rowLen; i++) {
            for (int j = 0; j < colLen; j ++) {
                if (matrix[i][j] < matrix[i][row[i]]) {
                    row[i] = j;
                }

                if (matrix[i][j] > matrix[col[j]][j]) {
                    col[j] = i;
                }
            }
        }

        for (int i = 0; i < rowLen; i ++) {
            if (i == col[row[i]]) {
                result.add(matrix[i][row[i]]);
            }
        }

        return result;
    }
//    public List<Integer> luckyNumbers(int[][] matrix) {
//        List<Integer> minRow = new ArrayList<>();
//        List<Integer> luckeynums = new ArrayList<>();
//
//        for (int i = 0; i < matrix.length; i ++) {
//            int min = matrix[i][0];
//            for (int j = 1; j < matrix[0].length; j++) {
//                min = Math.min(min, matrix[i][j]);
//            }
//            minRow.add(min);
//        }
//
//        for (int i = 0; i < matrix[0].length; i ++) {
//            int max = matrix[0][i];
//            for (int j = 1; j < matrix.length; j ++) {
//                max = Math.max(max, matrix[j][i]);
//            }
//            if (minRow.contains(max)) {
//                luckeynums.add(max);
//            }
//        }
//        return luckeynums;
//
//    }

    public static void main(String[] args) {
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        No_1380 test = new No_1380();
        List<Integer> list = test.luckyNumbers(matrix);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
