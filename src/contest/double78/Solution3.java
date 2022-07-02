package contest.double78;

import java.util.Arrays;

public class Solution3 {
    public static int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (o1, o2) -> o1[0] - o2[0]);
        int res = 0;
        int l = 0, r = 0;
        int cnt = 0;
        int end = tiles[l][0] + carpetLen - 1;
        while (r < tiles.length) {
            if (tiles[r][0] > end) {
                cnt -= Math.min(end, tiles[l][1]) - tiles[l][0] + 1;
                if (r - l > 1) {
                    cnt -= Math.min(end, tiles[r - 1][1]) - tiles[r - 1][0] + 1;
                    r--;
                }
                l ++;
                end = tiles[l][0] + carpetLen - 1;
            } else {
                cnt += Math.min(tiles[r][1], end) - tiles[r][0] + 1;
                r ++;
            }

            res = Math.max(res, cnt);
        }

        return res;
    }

    public static void main(String[] args) {
//        int[][] tiles = {{10,11},{1,5}, {12, 18}, {20, 25}, {30, 32}};
        int[][] tiles = {{10, 11}, {1,1}};
        System.out.println(maximumWhiteTiles(tiles,2));
    }
}
