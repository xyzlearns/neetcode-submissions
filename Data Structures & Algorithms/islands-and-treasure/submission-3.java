class Solution {

    private static final int INF = 2147483647;

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Add all treasures to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] d : dirs) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                // Skip walls and already visited cells
                if (grid[nr][nc] != INF)
                    continue;

                // Distance is parent's distance + 1
                grid[nr][nc] = grid[curr[0]][curr[1]] + 1;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}