package SwordToOffer.easy;

/**
 * No.15 二进制中1的个数 (Microsoft)
 */
public class Offer_15 {
    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            n = n & (n - 1);
            cnt ++;
        }

        return cnt;
    }
}
