public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        // 如果边数不等于 n - 1，则不可能是树
        if (edges.length != n - 1) {
            return false;
        }

        // 初始化并查集
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 遍历所有边，尝试合并节点
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            // 如果两个节点已经属于同一个集合，则存在环
            if (find(parent, node1) == find(parent, node2)) {
                return false;
            }

            // 合并两个节点
            union(parent, node1, node2);
        }

        // 如果没有环且边数为 n - 1，则是树
        return true;
    }

    // 并查集的 find 方法（路径压缩）
    private int find(int[] parent, int node) {
        if (parent[node] != node) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    // 并查集的 union 方法
    private void union(int[] parent, int node1, int node2) {
        int root1 = find(parent, node1);
        int root2 = find(parent, node2);
        if (root1 != root2) {
            parent[root1] = root2;
        }
    }

    public static void main(String[] args) {
        GraphValidTree solution = new GraphValidTree();
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {0, 3}, {1, 4}};
        System.out.println(solution.validTree(n, edges)); // 输出: true
    }
}