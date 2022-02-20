package middle.Array;

/**
 * No.838 推多米诺
 */
public class No_838 {
    public String pushDominoes(String dominoes) {
        String preStr = dominoes;
        int len = dominoes.length();
        while (true) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len; i++) {
                if (i == 0) {
                    if (preStr.charAt(i) == '.' && len > 1 && preStr.charAt(i + 1) == 'L') {
                        sb.append('L');
                    } else {
                        sb.append(preStr.charAt(i));
                    }
                } else if (i == len - 1) {
                    if (preStr.charAt(i) == '.' && preStr.charAt(i - 1) == 'R') {
                        sb.append('R');
                    } else {
                        sb.append(preStr.charAt(i));
                    }
                } else if (preStr.charAt(i) == '.') {
                    if (preStr.charAt(i - 1) == 'R' && preStr.charAt(i + 1) != 'L') {
                        sb.append('R');
                    } else if (preStr.charAt(i - 1) != 'R' && preStr.charAt(i + 1) == 'L') {
                        sb.append('L');
                    } else {
                        sb.append(preStr.charAt(i));
                    }
                } else {
                    sb.append(preStr.charAt(i));
                }
            }

            if (sb.toString().equals(preStr)) {
                return preStr;
            } else {
                preStr = sb.toString();
            }
        }
    }
}
