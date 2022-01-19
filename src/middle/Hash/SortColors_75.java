package middle.Hash;

/**
 * No.75 颜色分类 hash法
 */
public class SortColors_75 {

    public void sortColors(int[] nums) {
        int[] color = new int[] {0, 0, 0};
        for (int i : nums) {
            color[i] ++;
        }

        for (int i = 0; i < color[0]; i ++) {
            nums[i] = 0;
        }

        for (int i = color[0]; i < color[0] + color[1]; i ++) {
            nums[i] = 1;
        }

        for (int i = color[0] + color[1]; i < nums.length; i ++) {
            nums[i] = 2;
        }
    }
}
