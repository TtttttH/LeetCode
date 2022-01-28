package hard.greedy;

/**
 * No.135 分发糖果
 */
public class No_135 {
    public int candy(int[] ratings) {
        if (ratings.length == 1) {
            return 1;
        }

        int len = ratings.length;
        int[] candy = new int[len];

        candy[0] = 1;
        for (int i = 1; i < len; i ++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            } else {
                candy[i] = 1;
            }
        }

        for (int i = len - 2; i >=0; i --) {
            if (ratings[i] > ratings[i + 1]) {
                candy[i] = Math.max(candy[i + 1] + 1, candy[i]);
            }
        }

        int res = 0;
        for (int count : candy) {
            res += count;
        }

        return res;
    }
}
