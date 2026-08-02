class Solution {
    int land = 2147483647;
    int chest =0;
    int water = 0-1;

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int pos = grid[i][j];
                if(pos==water || pos == chest) continue;
                
                grid[i][j] = bfs(grid,i,j);
                
            }
        }
    }

    public int bfs(int[][] grid,int i,int j){
        Queue<int[]> q = new LinkedList< >();
        HashSet<String> visited = new HashSet<>();
        
        int m = grid.length;
        int n=grid[0].length;

        q.offer(new int[]{i,j});
        int count = 0;

        while(!q.isEmpty()){
            int size = q.size();
            
            for(int k=0;k<size;k++){

                int[] pos = q.poll();
                int r = pos[0];
                int c = pos[1];
                String p = r + "," + c;

                if(grid[r][c]==chest) return count;
                if(grid[r][c]==water) continue;
                if(visited.contains(p)) continue;
                visited.add(p);
        
                if(r-1>=0) q.offer(new int[]{r-1,c});
                if(c+1 <n) q.offer(new int[]{r,c+1});
                if(r+1<m) q.offer(new int[]{r+1,c});
                if(c-1>=0) q.offer(new int[]{r,c-1});
                
            }

            count++;
        }
        return land;
    }

    
}
