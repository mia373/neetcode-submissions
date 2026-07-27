class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) { // Start DFS only on land cells
                    maxArea = Math.max(dfs(grid, i, j), maxArea);
                }
            }
        }

        return maxArea;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[row].length || grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0; // Mark as visited
        int count = 1; // Start with the current cell

        // Accumulate the size of the island from all four directions
        count += dfs(grid, row + 1, col);
        count += dfs(grid, row, col + 1);
        count += dfs(grid, row - 1, col);
        count += dfs(grid, row, col - 1);

        return count;
    }
}