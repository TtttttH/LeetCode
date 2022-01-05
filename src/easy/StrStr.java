package easy;

/**
 * No.28 实现strStr() KMP
 */
public class StrStr {
    public int strStr (String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }

        int length = haystack.length();
        char[] chars = new char[length];
        for (int i = 0; i < chars.length; i ++) {
            chars[i] = haystack.charAt(i);
        }
        int left = 0;
        String str = "";
        boolean flg = false;
        for (int right = 0; right < length; right ++) {
            str = str + chars[right];
            if (str.contains(needle)) {
                flg = true;
                break;
            }
        }
        if (flg) {
            while(str.contains(needle)) {
                str = str.replaceFirst(str.charAt(0) + "", "");
                left ++;
            }
        } else {
            return -1;
        }

        return left - 1;
    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        StrStr st = new StrStr();
        System.out.printf(st.strStr(haystack, needle) + "");
    }
}
