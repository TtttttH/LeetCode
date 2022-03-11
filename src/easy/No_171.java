package easy;

/**
 * No.171 Excel 表列序号
 */
public class No_171 {
    public int titleToNumber(String s) {
        if (s == null || s.equals("")) return 0;
        int res = 0;
        for (char ch : s.toCharArray()) {
            res = res * 26 + ch - 'A';
            res ++;
        }

        return res;
    }
}
