package middle.Array;

/**
 * No.955 删列造序II (Microsoft)
 */
public class No_955 {
    public int minDeletionSize(String[] strs) {
        int col = strs[0].length();
        int row = strs.length;
        int res = 0;
        boolean[] already = new boolean[row - 1];
        for (int i = 0; i < col; i ++) {
            boolean save = true;
            for (int j = 0; j < row - 1; j ++) {
                char cur = strs[j + 1].charAt(i);
                char pre = strs[j].charAt(i);
                if (!already[j] && cur < pre) {
                    res++;
                    save = false;
                    break;
                }
            }

            //如果当前列保留，更新已经不需要判断的行状态
            if (save) {
                for (int j = 0; j < row - 1; j ++) {
                    if (strs[j + 1].charAt(i) > strs[j].charAt(i)) already[j] = true;
                }
            }
        }

        return res;
    }
}
