class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]
        ROWS, COLS = len(grid), len(grid[0])
        max_area = 0

        def dfs(r, c):
            if (r < 0 or c < 0 or r >= ROWS or c >= COLS or grid[r][c] == 0):
                return 0

            grid[r][c] = 0
            count = 1

            for dr, dc in directions:
                count += dfs(r + dr, c + dc)
            return count

        for r in range(ROWS):
            for c in range(COLS):
                if grid[r][c] == 1:
                    max_area = max(max_area, dfs(r, c))

        return max_area