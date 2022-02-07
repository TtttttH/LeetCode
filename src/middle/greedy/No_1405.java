package middle.greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * No.1405 最长快乐串
 */
public class No_1405 {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<LetterCount> queue = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        if (a > 0) queue.add(new LetterCount(a, 'a'));
        if (b > 0) queue.add(new LetterCount(b, 'b'));
        if (c > 0) queue.add(new LetterCount(c, 'c'));
        char preChar = '.';
        int preCount = 0;
        StringBuilder sb = new StringBuilder();
        while(queue.size() > 0) {
            LetterCount lc = queue.poll();
            if (preChar != lc.letter || preCount < 2) {
                sb.append(lc.letter);
                preCount = preChar == lc.letter ? 2 : 1;//注意这里要先判断，再修改preChar值
                preChar = lc.letter;
                if (lc.count > 1) queue.add(new LetterCount(lc.count - 1, lc.letter));
            } else { //当前最大元素在sb尾部已出现两次
                if (queue.size() == 0) {
                    break;
                }
                LetterCount lc1 = queue.poll();
                sb.append(lc1.letter);
                preChar = lc1.letter;
                preCount = 1;
                if (lc1.count > 1) queue.add(new LetterCount(lc1.count - 1, lc1.letter));
                queue.add(lc);
            }
        }

        return sb.toString();
    }

    class LetterCount {
        char letter;
        int count;
        public LetterCount(int count, char letter) {
            this.letter = letter;
            this.count = count;
        }
    }
}
