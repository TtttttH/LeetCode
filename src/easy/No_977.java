package easy;

/**
 * No.977 有序数组的平方
 */
public class No_977 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] result = new int[nums.length];

        int left = 0;
        int right = nums.length - 1;
        int k = nums.length -1;
        while (left <= right) {
            if (nums[left] * nums[left] < nums[right] * nums[right]) {
                result[k --] = nums[right] * nums[right];
                right --;
            } else {
                result[k --] = nums[left] * nums[left];
                left ++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-4, -1, 0 ,3, 10};
        No_977 ss = new No_977();
        int[] res = ss.sortedSquares(nums);
        for (int i = 0; i < res.length; i ++) {
                System.out.printf((res[i]) + "  ");
        }
    }
}
