package middle.binarySearch;

/**
 * No.540  Single Element in a Sorted Array
 */
public class No_540 {
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (mid % 2 == 1) {
                mid --;
            }
            if (nums[mid] != nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 2;
            }
            System.out.println("left:" + left + "right:" + right+ "mid:" + mid);

        }

        return nums[left];
    }

    public static void main(String[] args) {
//        int[] nums = {1,1,2,3,3,4,4,8,8};
        int[] nums = {1,2,2,3,3,4,4,8,8};
        No_540 test = new No_540();
        System.out.println(test.singleNonDuplicate(nums));
    }
}
