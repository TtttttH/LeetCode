package middle.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No.77: 给定两个整数n 和 k,返回范围[1, n] 中所有可能的k个数的组合
 */
public class Combine {
    List<List<Integer>> resList = new ArrayList<>();
    public List<List<Integer>> combine (int n, int k) {
        if (n < 1 || k < 1 || n < k) {
            return resList;
        }

        for (int i = 1; i < n - k + 2; i ++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            backTrack(n, k- 1, i, list);
        }

        return resList;
    }

    private void backTrack (int n, int k, int preNumber, List<Integer> list) {
        if(k == 0) {
            // 注意这里一定要new一个list去复制list，直接复制list到resList的话，
            // 后面回溯撤销最后一位数的时候会把结果集中的list也一并改变
            resList.add(new ArrayList<>(list));
            return;
        }

        for(int i = preNumber + 1; i < n - k + 2; i ++ ) {
            list.add(i);
            backTrack(n, k -1, i, list);
            list.remove(Integer.valueOf(i));
        }
    }

    public static void main(String[] args) {
        Combine cb = new Combine();
        System.out.printf(cb.combine(4,4).toString());
    }
}
