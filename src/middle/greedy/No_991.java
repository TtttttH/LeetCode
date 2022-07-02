package middle.greedy;

/**
 * No.991 坏了的计算器 (middle)
 */
public class No_991 {
    public int brokenCalc(int startValue, int target) {
        int res = 0;
        while (startValue < target) {
            if (target % 2 == 0) {
                target /= 2;
                res ++;
            } else {
                target = (target + 1) / 2;
                res += 2;
            }
        }

        return res + startValue - target;
    }
}
