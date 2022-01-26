package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * No.118 杨辉三角
 */
public class No_118 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        result.add(list);
        if (numRows == 1) {
            return result;
        }

        addList(numRows, 1, list);
        return result;
    }

    private void addList(int numRows, int depth, List<Integer> prelist) {
        if (depth > numRows) {
            return;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < prelist.size() - 1; i ++) {
            list.add(prelist.get(i) + prelist.get(i + 1));
        }
        list.add(1);
        result.add(list);
        addList(numRows, depth + 1, list);
    }
}
