package middle.graph;

import java.util.*;

/**
 * No.133 克隆图 (Microsoft)
 */
public class No_133 {
    //bfs
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        Map<Integer, Node> map = new HashMap<>();
        Deque<Node> queue = new LinkedList<>();
        queue.offer(node);
        map.put(node.val, new Node(node.val));
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Node clone = map.get(n.val);
            List<Node> neighbors = n.neighbors;
            for (Node neighbor : neighbors) {
                Node cloneNeigh = map.get(neighbor.val);
                if (cloneNeigh == null) {
                    cloneNeigh = new Node(neighbor.val);
                    map.put(neighbor.val, cloneNeigh);
                }
                clone.neighbors.add(cloneNeigh);
                queue.add(neighbor);
            }
        }

        return map.get(node.val);
    }


    //dfs
    Map<Node, Node> visited = new HashMap<>();
    public Node dfs(Node node) {
        if (node == null) return null;
        if (visited.containsKey(node)) return visited.get(node);

        Node clone = new Node(node.val);
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor));
        }

        return clone;
    }
    class Node {
        public int val;
        public List<Node> neighbors;
        public Node() {
            this.val = 0;
            this.neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, List<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }
}
