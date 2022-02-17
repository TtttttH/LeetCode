package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.119 杨辉三角II
 */
public class No_119 {
    public List<Integer> getRow(int rowindex) {
        List<Integer> pre = new ArrayList<>();
        for (int i = 0; i <= rowindex; i ++) {
            List<Integer> cur = new ArrayList<>();
            for (int j = 0; j <= i; j ++) {
                if (j == 0 || j == i) {
                    cur.add(1);
                } else {
                    cur.add(pre.get(j - 1) + pre.get(j));
                }
            }

            pre = cur;
        }
        return pre;
    }

//    private List<Integer> getRow(int rowIndex, List<Integer> row) {
//        if (rowIndex == 0) {
//            return row;
//        }
//
//        List<Integer> nextRow = new ArrayList<>();
//        nextRow.add(1);
//        for (int i = 0; i < row.size() - 1; i ++) {
//            nextRow.add(row.get(i) + row.get(i + 1));
//        }
//
//        nextRow.add(1);
//        return getRow(rowIndex - 1, nextRow);
//    }


    public static void main(String[] args) {
        No_119 test = new No_119();
        List<Integer> ans = test.getRow(3);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
