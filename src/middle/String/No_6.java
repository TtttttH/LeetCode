package middle.String;

import java.util.ArrayList;
import java.util.List;

/**
 * No.6 Z子形变换 (middle)
 */
public class No_6 {
    public String convert(String s, int numRows) {
        if (numRows == 1) { //如果只有一行则返回原字符串即可
            return s;
        }
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i ++) {
            list.add(new StringBuilder());
        }
        boolean goingDown = false;
        int curRow = 0;
        for (char ch : s.toCharArray()) {
            list.get(curRow).append(ch);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
//            curRow = goingDown? curRow + 1 : curRow - 1;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : list) {
            result.append(sb);
        }
        return result.toString();
    }
}
