package easy.dp;

/**
 * No.70 爬楼梯
 */
public class ClimbStairs_70 {
    public int climbStairs(int n ) {
        if (n <= 2) {
            return n;
        }

        int a = 1, b = 2, sum = 0;
        for (int i = 3; i <= n; i ++) {
            sum = a + b;
            a = b;
            b = sum;
        }

        return sum;
    }
}
