class Solution {
    Map<Integer,List<Integer>> map = new HashMap<>();
    
    boolean valid = true;

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        adjacencyList(prerequisites);
        for(int key: map.keySet()){
            dfs(key,new HashSet<>());
        }

        return valid;
        
    }

    public void dfs(int key,Set<Integer> visited){
        if(visited.contains(key)){
            valid = false;
            return;
        }
        visited.add(key);
        
        if(map.get(key)!=null){
            
            List<Integer> neighbours = map.get(key);
            for(int neighbour : neighbours){
                dfs(neighbour,visited);
            }
        }

        visited.remove(key);
        
    }

    public void adjacencyList(int[][] prerequisites){
        //adjacency list maker
        for(int[] r : prerequisites){
            if(map.containsKey(r[1])){
                map.get(r[1]).add(r[0]);
            }
            else{
                List<Integer> list = new ArrayList<>();
                list.add(r[0]);
                map.put(r[1],list);
            }
        }
    }
}
