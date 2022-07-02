package middle.unionFindSet;

/**
 * No.547 省份数量(Microsoft)
 */
public class No_547 {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        if (n == 1) return 1;
        UnionFind uf = new UnionFind(isConnected);
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < n; j ++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }

        return n - uf.mergeCount;
    }
    
    
    class UnionFind {
        int[] parent;
        int[] rank;
        int mergeCount;

        public UnionFind(int[][] isConnected) {
            int n = isConnected.length;
            parent = new int[n];
            rank = new int[n];
            mergeCount = 0;
            for (int i = 0; i < n; i ++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x) {
            //路径压缩
            if (parent[x] == x) return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void union(int x, int y) {
            //求两元素的根节点的的树高
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                if (rank[rootX] <= rank[rootY]) {
                    parent[rootX] = rootY; //把x的根挂在的根上
                } else {
                    parent[rootY] = rootX;
                }
                mergeCount ++;
                if (rank[rootX] == rank[rootY]) rank[rootX]++;
            }
        }
    }
}
