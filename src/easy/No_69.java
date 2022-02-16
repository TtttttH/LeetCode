package easy;

/**
 * No.69 Sqrt(x)
 */
public class No_69 {

    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int left = 0;
        int right = x;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (mid <= x / mid) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}
