package middle.doublepoint;

/**
 * No.838 推多米诺 双指针解法 O(n) O(1)
 */
public class No_838 {
    public String pushDominoes(String dominoes) {
        dominoes = 'L' + dominoes + 'R';
        int l = 0;
        StringBuilder sb = new StringBuilder();
        for (int r = 1; r < dominoes.length(); r ++) {
            if (dominoes.charAt(r) == '.') continue;
            if (l != 0) sb.append(dominoes.charAt(l));
            int points = r - l - 1; //表示[l, r) 中有多少个 '.'
            if (dominoes.charAt(l) == dominoes.charAt(r)) {
                for (int i = 0; i < points; i ++) {
                    sb.append(dominoes.charAt(l));
                }
            } else if (dominoes.charAt(l) == 'L' && dominoes.charAt(r) == 'R') {
                for (int i = 0; i < points; i ++) {
                    sb.append('.');
                }
            } else {  //这里l = 'R', r = 'L'
                for (int i = 0; i < points / 2; i ++) {
                    sb.append('R');
                }

                if (points / 2 == 1) {
                    sb.append('.');
                }

                for (int i = 0; i < points / 2; i ++) {
                    sb.append('L');
                }
            }

            l = r;
        }

        return sb.toString();
    }
}
