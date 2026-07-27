class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') {
            return;
        }

        grid[row][col] = '0'; // Mark as visited

        dfs(grid, row + 1, col); // Down
        dfs(grid, row - 1, col); // Up
        dfs(grid, row, col + 1); // Right
        dfs(grid, row, col - 1); // Left
    }
}
