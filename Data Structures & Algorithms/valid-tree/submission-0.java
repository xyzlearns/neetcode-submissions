class Solution {
    HashMap<Integer,List<Integer>> map  =new HashMap<>();
    HashSet<Integer> visited = new HashSet<>();

    public boolean validTree(int n, int[][] edges) {
        if(edges.length >= n) return false;

        adjacencyList(edges,n);

        if(!dfs(0,-1)){
            return false;
        }

        return visited.size() == n;

    }

    public boolean dfs(int node,int parent){
        if(visited.contains(node)) {
            return false;
        }
        visited.add(node);

        for(int nei : map.get(node)){
            if(nei==parent) continue;

            if(!dfs(nei,node)) return false;
            
        }
        return true;
    }

    public void adjacencyList(int[][] edges,int n) {

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            map.get(u).add(v);
            map.get(v).add(u);
            
        }
    }
}
