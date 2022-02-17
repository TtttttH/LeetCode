package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.119 杨辉三角II
 */
public class No_119 {
    public List<Integer> getRow(int rowindex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        return getRow(rowindex, list);
    }

    private List<Integer> getRow(int rowIndex, List<Integer> row) {
        if (rowIndex == 0) {
            return row;
        }

        List<Integer> nextRow = new ArrayList<>();
        nextRow.add(1);
        for (int i = 0; i < row.size() - 1; i ++) {
            nextRow.add(row.get(i) + row.get(i + 1));
        }

        nextRow.add(1);
        return getRow(rowIndex - 1, nextRow);
    }


    public static void main(String[] args) {
        No_119 test = new No_119();
        List<Integer> ans = test.getRow(3);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
