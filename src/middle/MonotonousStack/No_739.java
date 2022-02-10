package middle.MonotonousStack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * No.739 Daily Temperatures
 */
public class No_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }

            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
//        int[] a = {30, 60, 90};
        int[] a = {15, 10, 30, 25, 25, 25, 10, 30};
        No_739 test = new No_739();
        int[] ans = test.dailyTemperatures(a);
        for (int i : ans) {
            System.out.print(i);
        }
    }
}
