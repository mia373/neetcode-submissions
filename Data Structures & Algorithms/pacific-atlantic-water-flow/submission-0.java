class Solution {
    //four differet directions in 2D array
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
       
        //perform dfs starting from the boarder (the first row for pacific ocean and the last row for atlantic ocean)
        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }

        //perform dfs starting from the boarder (the first column for pacific ocean and the last column for atlantic ocean)
        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) {
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        //mark the current cell as true (false is default)
        ocean[r][c] = true;
        
        //search four directions for the current cell
        for (int[] d : directions) {
            //get the new row and new column number
            int nr = r + d[0], nc = c + d[1];
            
            //perform dfs on the new cell if it's within bounds and it's false (we haven't visited before) and its height >= current height
            if (nr >= 0 && nr < heights.length && 
                nc >= 0 && nc < heights[0].length && 
                !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, ocean, heights);
            }
        }
    }
}
