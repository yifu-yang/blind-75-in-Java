public class NumberOfConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        // 初始化并查集
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // 合并节点
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            union(parent, node1, node2);
        }

        // 统计连通分量的数量
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == i) {
                count++;
            }
        }

        return count;
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
        NumberOfConnectedComponents solution = new NumberOfConnectedComponents();
        int n = 5;
        int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(solution.countComponents(n, edges)); // 输出: 2
    }
}