package hard.queue_stack;

import java.util.PriorityQueue;

/**
 * No.295 数据流中的中位数
 */
public class MedianFinder {

    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public MedianFinder() {
        this.queueMin = new PriorityQueue<>((o1, o2) -> (o2 - o1)); //大顶堆
        this.queueMax = new PriorityQueue<>((o1, o2) -> (o1 - o2)); //小顶堆
    }

    public void addNum(int num) {
        if (queueMin.isEmpty() || queueMin.peek() > num) {
            queueMin.offer(num);
            if (queueMax.size() + 1 < queueMin.size()) queueMax.offer(queueMin.poll());
        } else {
            queueMax.offer(num);
            if (queueMin.size() < queueMax.size()) queueMin.offer(queueMax.poll());
        }
    }

    public double findMedian() {
        if (queueMin.size() > queueMax.size()) return (double) queueMin.peek();
        else return (double) (queueMin.peek() + queueMax.peek()) / 2.0;
    }
}
