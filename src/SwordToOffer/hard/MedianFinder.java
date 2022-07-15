package SwordToOffer.hard;

import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> queueMin;
    PriorityQueue<Integer> queueMax;

    public MedianFinder() {
        queueMin = new PriorityQueue<>((o1, o2) -> (o2 - o1));
        queueMax = new PriorityQueue<>((o1, o2) -> (o1 - o2));
    }

    public void addNum(int num) {
        if (queueMin.isEmpty() || num <= queueMin.peek()) {
            queueMin.offer(num);
            if (queueMax.size() + 1 < queueMin.size()) {
                queueMax.offer(queueMin.poll());
            }
        } else {
            queueMax.offer(num);
            if (queueMax.size() > queueMin.size()) {
                queueMin.offer(queueMax.poll());
            }
        }
    }

    public double findMedian() {
        if (queueMin.size() == queueMax.size()) {
            return (double) (queueMin.peek() + queueMax.peek()) / 2.0;
        } else {
            return queueMin.peek();
        }
    }
}
