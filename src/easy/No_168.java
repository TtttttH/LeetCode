package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * No.168 Excel表列名称
 */
public class No_168 {
    public String convertToTitle(int columnNumber) {
        if (columnNumber <= 0) return "";
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            columnNumber --;
            sb.append((char) (columnNumber % 26 + 'A'));
            columnNumber /= 26;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        int columnNumber = 27;
        No_168 test = new No_168();
        System.out.println(test.convertToTitle(columnNumber));
    }

}
