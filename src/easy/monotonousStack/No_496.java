package easy.monotonousStack;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * No.496 Next Greater Element I
 */
public class No_496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Deque<Integer> stack = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums2) {
            while (!stack.isEmpty() && num > stack.peek()) {
                int preNum = stack.pop();
                map.put(preNum, num);
            }

            stack.push(num);
        }

        for (int i = 0; i < nums1.length; i ++) {
            ans[i] = map.getOrDefault(nums1[i], - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,4};
        int[] nums2 = {1,2,3,4};
        No_496 test = new No_496();
        int[] ans = test.nextGreaterElement(nums1, nums2);
        for (int i : ans) {
            System.out.println(i);
        }
    }
}
