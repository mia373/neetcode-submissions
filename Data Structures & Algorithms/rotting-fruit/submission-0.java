class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int time = 0;
        int fresh = 0; 

        int m = grid.length;
        int n = grid[0].length;

        // Collect all rotten fruit as starting points and store the number of fresh fruit
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j}); 
                } else if (grid[i][j] == 1) {
                    fresh++; 
                }
            }
        }

        // If there are no fresh oranges, return 0 (already rotten or empty grid)
        if (fresh == 0) return 0;
        
        // Define possible directions (up, left, down, right)
        int[][]dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        
        // BFS traversal
        //Remember to check if fresh > 0
        while (fresh > 0 && !q.isEmpty()) {
            int size = q.size(); 

            for (int i = 0; i < size; i++) {
                int[] node = q.poll();
                int row = node[0];
                int col = node[1];

                for (int[] dir: dirs) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    
                    // Check bounds and ensure we only visit fresh fruit
                    if (r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == 1) {
                        fresh--;
                        grid[r][c] = 2; 
                        q.add(new int[]{r, c});
                    }
                }
            }

            time++;   // Update minute for every level of BSF traversal
        }

        return fresh == 0 ? time : -1;
    }
}
