public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length > n - 1) {
            return false;
        }

        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n ; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        Set<Integer> visit = new HashSet<>();

        if (!dfs(0, -1, visit, adj)) {
            return false;
        }

        return visit.size() == n;

    }

    public boolean dfs(int node, int parent, Set<Integer> visit, List<List<Integer>> adj){
        if(visit.contains(node)){
            return false;
        }

        visit.add(node);

        for(int i = 0; i < adj.get(node).size(); i++){
            if(adj.get(node).get(i) == parent){
                continue;
            }
            if(!dfs(adj.get(node).get(i), node, visit, adj)){
                return false;
            }
        }

        return true;
    }
}
