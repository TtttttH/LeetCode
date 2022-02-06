package easy;

/**
 * No.1748 唯一元素的和
 */
public class No_1748 {
    public int sumOfUnique(int[] nums) {
        int[] count = new int[101];
        for (int num : nums) {
            count[num] ++;
        }

        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (count[i] == 1) {
                sum += i;
            }
        }
        return sum;
    }
}
