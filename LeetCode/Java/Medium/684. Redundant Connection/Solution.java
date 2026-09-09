class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;
        for (int[] e : edges) {
            int a = find(e[0]);
            int b = find(e[1]);
            if (a == b)
                return e;
            parent[a] = b;
        }
        return new int[0];
    }
    int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }
}