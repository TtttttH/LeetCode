package easy;

/**
 * No.14 最长公共前缀
 */
public class No_14 {
    public String longestCommonPrefix(String[] strs) {
        if(null == strs || strs.length == 0) {
            return "";
        }
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int maxLength = Math.min(res.length(), strs[i].length());
            res = res.substring(0, maxLength);
            for (int j = 0; j < maxLength; j ++) {
                if (strs[i].charAt(j) != res.charAt(j)) {
                    res = res.substring(0, j);
                    maxLength = res.length();
                    if (res.equals("")) {
                        return "";
                    }
                }
            }
        }
        return res;
//        for (int i = 1; i < res.length(); i ++) {
//            for (int j = 1; j < Math.min(strs.length, res.length()); j++) {
//                if (res.equals("")) {
//                    return res;
//                }
//                if (strs[i].charAt(j) != res.charAt(j)) {
//                    res = res.substring(0, j);
//                    continue;
//                }
//            }
//        }
//        return res;
    }

    public static void main(String[] args) {
        No_14 lcp = new No_14();
        String[] strs = {"flower","flow","flight"};
        System.out.printf(lcp.longestCommonPrefix(strs));
    }
}
