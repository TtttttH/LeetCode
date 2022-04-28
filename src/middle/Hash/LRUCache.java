package middle.Hash;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * No.146 LRU缓存 (Microsoft)
 */
public class LRUCache {
    private Node head;
    private Node tail;
    int capacity;
    int size;
    private Map<Integer, Node> cache = new HashMap<>();
    public LRUCache(int capacity) {
        head = new Node ();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
        this.size = 0;
    }

    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int val) {
        Node node = cache.get(key);
        if (node != null) {
            node.val = val;
            moveToHead(node);
        } else {
            node = new Node(key, val);
            if (size == capacity) {
                Node last = removeLast();
                cache.remove(last.key);
            }
            addToHead(node);
            cache.put(key, node);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node node) {
        size --;
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void addToHead(Node node) {
        head.next.pre = node;
        node.next = head.next;
        node.pre = head;
        head.next = node;
        size ++;
    }

    private Node removeLast() {
        Node last =  tail.pre;
        removeNode(last);
        return last;
    }
    class Node {
        Node next;
        Node pre;
        int key;
        int val;
        public Node() {}
        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }


    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(2, 2);
        cache.get(2);
        cache.put(1, 1);
        cache.put(4,1);
        cache.get(2);
    }
}
