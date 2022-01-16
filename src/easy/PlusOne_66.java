package easy;

/**
 * No.66 加一
 */
public class PlusOne_66 {
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        for (int i = len - 1; i >= 0; i --) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                break;
            }
        }

        if (digits[0] == 0) {
            int[] results = new int[len + 1];
            results[0] = 1;
            for (int i = 1; i < len + 1; i ++) {
                results[i] = 0;
            }
            return results;
        } else {
            return digits;
        }
    }
}
