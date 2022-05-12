package middle.Array;

/**
 * No.80 删除有序数组中的重复项II (Microsoft)
 */
public class No_80 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int fast = 2, slow = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow ++;
            }

            fast ++;
        }

        return slow;
    }

    //general solution
    public int generalResolve(int[] nums, int k) {
        int u = 0;
        for (int num : nums) {
            if (u < k || nums[u - k] != num) nums[u ++] = num;
        }

        return u;
    }
}
