package middle.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * No.93 复原IP地址
 */
public class RestoreIpAddresses_93 {

    List<String> results = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return results;
        }

        backtracking(s, 0, 0);
        return results;
    }

    private void backtracking(String s, int startIndex, int pointNum) {
        if (pointNum == 4) {
            if (startIndex == s.length()) {
                StringBuilder temp = new StringBuilder(sb);
                temp.deleteCharAt(temp.length() - 1);
                results.add(temp.toString());
            }

            return;
        }

        for (int i = startIndex; i < s.length(); i ++) {
            if (isEligible(s, startIndex, i + 1)) {
                sb.append(s, startIndex, i + 1).append(".");
                backtracking(s, i + 1, pointNum + 1);
                //这里要注意删除时候的长度，是上一分割子串再加上一个句号的长度
                sb.delete(sb.length() - (i + 1 - startIndex) - 1, sb.length());
            } else {
                break;
            }
        }
    }

    private boolean isEligible(String s, int start, int end) {
        if (start + 1 < end && s.charAt(start) == '0') {
            return false;
        }

        int num = 0;
        for (int i = start; i < end; i++) {
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) {
                return false;
            }
        }

        return true;
    }
}
