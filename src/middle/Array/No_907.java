package middle.Array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * No.907 子数组的最小值之和 (Microsoft)
 */
public class No_907 {
    public int sumSubarrayMins(int[] arr) {
        //思路:类似No.84 最大矩阵面积，单调栈加每个元素的前后边界双DP数组
        int n = arr.length;
        int[] pre = new int[n];
        int[] next = new int[n];
        Arrays.fill(pre, -1);
        Arrays.fill(next, n);
        Deque<Integer> stack1 = new LinkedList<>();
        for (int i = 0; i < n; i ++) {
            while (!stack1.isEmpty() && arr[i] < arr[stack1.peek()])  {
                next[stack1.pop()] = i;
            }
            stack1.push(i);
        }

        Deque<Integer> stack2 = new LinkedList<>();
        for (int i = n - 1; i >= 0 ; i --) {
            while (!stack2.isEmpty() && arr[i] <= arr[stack2.peek()]) {
                pre[stack2.pop()] = i;
            }

            stack2.push(i);
        }
        int mod = 1000000007;
        double res = 0;
        for (int i = 0; i < n; i ++) {
            res += (long) (next[i] - i) * (i - pre[i]) % mod * arr[i] % mod;
            res %= mod;
        }

        return (int)res;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        No_907 test = new No_907();
        System.out.println(test.sumSubarrayMins(arr));
    }
}
