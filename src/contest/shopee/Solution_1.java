package contest.shopee;

import java.util.Arrays;

public class Solution_1 {
    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int transfer = gem[operation[0]] / 2;
            gem[operation[0]] -= transfer;
            gem[operation[1]] += transfer;
        }

        Arrays.sort(gem);
        return gem[gem.length - 1] - gem[0];
    }
}
