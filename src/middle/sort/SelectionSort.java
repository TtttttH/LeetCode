package middle.sort;

/**
 * 选择排序
 * time complexity: O(n^2)
 * space complexity: O(1)
 * 不稳定
 */
public class SelectionSort {
    public static void selectionSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i ++) {
            int max = i;
            for (int j = i + 1; j < n; j ++) {
                if (nums[j] > nums[max]) {
                    max = j;
                }
            }

            if (max != i) {
                int temp = nums[i];
                nums[i] = nums[max];
                nums[max] = temp;
            }
        }

        for (int i = 0; i < n; i ++) {
            System.out.print(nums[i]);
            System.out.print(' ');
        }
    }
    public static void main(String[] args) {
        int[] arr = {3, 1, 4,0, 2, 1, 4, 5, 3, 8};
        SelectionSort.selectionSort(arr);
    }
}
