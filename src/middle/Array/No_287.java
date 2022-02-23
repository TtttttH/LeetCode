package middle.Array;

/**
 * No.287 寻找重复数
 */
public class No_287 {
    public int findDuplicate(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (true) {
            fast = nums[nums[fast]];
            slow = nums[slow];
            if (fast == slow) {
                slow = 0;
                while (fast != slow) {
                    fast = nums[fast];
                    slow = nums[slow];
                }

                return slow;
            }
        }
    }
}
