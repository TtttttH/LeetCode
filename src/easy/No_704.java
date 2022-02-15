package easy;

/**
 * No.704
 */
public class No_704 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(nums, 0, nums.length -1, target);
    }

    private int binarySearch(int[] nums, int begin, int end, int target) {
        if (begin == end) {
            return nums[begin] == target ? begin : -1;
        }
        int middle = begin + ((end - begin) >> 1);
        if (nums[middle] == target) {
            return middle;
        }
        if (target > nums[middle]) {
            return binarySearch(nums, middle+1, end, target);
        } else {
            return binarySearch(nums, begin, middle-1, target);
        }
    }
}
