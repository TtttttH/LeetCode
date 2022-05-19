package contest.cmbchina;

public class Solution_1 {
    public String deleteText(String article, int index) {
        if (article.charAt(index) == ' ') return article;
        char[] letters = article.toCharArray();
        int left = index, right = index;

        while (left >= 0 && letters[left] != ' ') left --;
        while (right < letters.length && letters[right] != ' ') right ++;
        StringBuilder sb = new StringBuilder();
        if (left >= 0 && right < letters.length) {
            sb.append(article, 0, left);
            sb.append(article.substring(right));
        } else if (right < letters.length) {
            sb.append(article.substring(right + 1));
        } else if (left >= 0) {
            sb.append(article, 0, left);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String article = "Hello World";
        Solution_1 test = new Solution_1();
        System.out.println(test.deleteText(article, 2));
    }
}
