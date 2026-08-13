class Solution {
    HashMap<Integer,List<Integer>> map =new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public int countComponents(int n, int[][] edges) {
        

        for(int i=0;i<n;i++){
            map.put(i,new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            map.get(edges[i][0]).add(edges[i][1]);
            map.get(edges[i][1]).add(edges[i][0]);
        }

        int count = 0;

        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                dfs(i);
                count++;
            }
        }

        return count;
    }

    public void dfs(int node){
        if(visited.contains(node)){
            return;
        }
        visited.add(node);
        
        for(int nei:map.getOrDefault(node,new ArrayList<>())){
            dfs(nei);
        }
    }
}
