class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        for(int i=1;i<n;i++){
            for(int[] edge : times){
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];
                if(distance[u] != Integer.MAX_VALUE && distance[u] + w < distance[v]){
                    distance[v] = distance[u] + w;
                }
            }
        }

        int res = 0;
        for(int i=1;i<=n;i++){
            if(distance[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, distance[i]);
        }
        return res;
    }
}