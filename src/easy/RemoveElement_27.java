package easy;

/**
 * No.27 移除元素
 */
public class RemoveElement_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (right >= 0 && nums[right] != val ) {
            right = right - 1;
        }
        while (left <= right) {
            if(nums[left] == val) {
                swap(nums, left, right);
                right --;
            } else {
                left ++;
            }
        }
        return right + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        RemoveElement_27 re = new RemoveElement_27();
        int[] nums = {2};
        System.out.println(re.removeElement(nums, 3));
    }
}
