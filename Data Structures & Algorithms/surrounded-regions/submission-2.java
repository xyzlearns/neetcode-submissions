class Solution {
    boolean edge;
    Set<String> visited = new HashSet<>();
    int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    List<List<Integer>> positions;
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                positions=new ArrayList<>();
                edge = false;
                String pos = i+","+j;
                if(board[i][j]=='O' && !visited.contains(pos)) dfs(board,i,j);
                if(!edge){
                    for(List<Integer> p :positions){
                        int p1 = p.get(0);
                        int p2 = p.get(1);

                        board[p1][p2] = 'X';
                    }
                }
            }
        }
    }

    public void dfs(char[][] grid,int r,int c){
        int n = grid.length;
        int m = grid[0].length;

        if(grid[r][c]=='X'){
            return ;
        }

        String pos = r+","+c;
        if(visited.contains(pos)){
            return;
        }

        visited.add(pos);
        positions.add(Arrays.asList(r,c));

        //dfs
        

        for(int[] dir : dirs){
            int nr = r + dir[0], nc = c + dir[1];
            
            boolean valid = nr>=0 && nc>=0 && nr<n && nc<m;
            
            if(valid) {
                dfs(grid,nr,nc);
            } 
            else {
                edge =true;
            }
            
        }
        
    }
}
