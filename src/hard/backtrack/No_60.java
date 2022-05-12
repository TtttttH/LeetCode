package hard.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * No.60 排列序列(Microsoft)
 */
public class No_60 {
    public String getPermutation(int n, int k) {
        int[] factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n ; i ++) {
            factorial[i] = factorial[i - 1] * i;
        }

        k --;
        StringBuilder sb = new StringBuilder();
        boolean[] valid = new boolean[n + 1];
        Arrays.fill(valid, true);
        for (int i = 1; i <= n; i ++) {
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; j ++) {
                if (!valid[j]) continue;
                order --;
                if (order == 0) {
                    valid[j] = false;
                    sb.append(j);
                    break;
                }
            }

            k %= factorial[n - i];
        }

        return sb.toString();
    }
    //超时
//    int num = 0;
//    StringBuilder res = new StringBuilder();
//    public String getPermutation(int n, int k) {
//        List<Integer> path = new ArrayList<>();
//        traversal(k, n, path);
//
//        return res.toString();
//    }
//
//    private void traversal(int k, int n, List<Integer> path) {
//        if(num == k) return;
//        if (path.size() == n) {
//            num ++;
//            if (num == k) {
//                for (int i : path) {
//                    res.append(i);
//                }
//            }
//            return ;
//        }
//        for (int i = 1; i <= n; i ++) {
//            if (path.contains(i)) continue;
//            path.add(i);
//            traversal(k, n, path);
//            path.remove(path.size() - 1);
//        }
//    }

    public static void main(String[] args) {
        No_60 test = new No_60();
        System.out.println(test.getPermutation(4, 9));
    }
}
