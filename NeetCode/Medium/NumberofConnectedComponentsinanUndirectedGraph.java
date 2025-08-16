class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        parent = new int[n];
        rank = new int[n];
        for(int i = 0; i < n; i++){
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int node) {
        int curr = node;
        while(curr != parent[curr]){
            parent[curr] = parent[parent[curr]];
            curr = parent[curr];
        }
        return curr;
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if(pu == pv){
            return false;
        }
        if(rank[pv] > rank[pu]){
            int temp = pu;
            pu = pv;
            pv = temp;
        }
        parent[pv] = pu;
        rank[pu] += rank[pv];
        return true;
    }
}

public class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int result = n;
        for(int[] edge : edges){
            if(dsu.union(edge[0], edge[1])){
                result--;
            }
        }
        return result;
    }
}