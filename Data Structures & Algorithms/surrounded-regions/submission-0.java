class Solution {
    //four differet directions in 2D array
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void solve(char[][] board) {
        int ROWS = board.length;
        int COLS = board[0].length;

        //perform dfs starting from the boarder (the first row and the last row)
        for (int c = 0; c < COLS; c++) {
            if(board[0][c] == 'O') {
                dfs(0, c, board);
            }
            
            if (board[ROWS - 1][c] == 'O') {
                dfs(ROWS - 1, c, board);
            }
        }

        //perform dfs starting from the boarder (the first column and the last column)
        for (int r = 0; r < ROWS; r++) {
            
            if (board[r][0] == 'O') {
                dfs(r, 0, board);
            }
            
            if (board[r][COLS - 1] == 'O') {
                dfs(r, COLS - 1, board);
            }   
        }

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (board[r][c] == 'O') {
                    board[r][c] = 'X';
                }

                if (board[r][c] == '#') {
                    board[r][c] = 'O';
                }
            }
        }

    }

    private void dfs(int r, int c, char[][] board) {
        //mark the current cell as '#' to avoid revisiting
        board[r][c] = '#';

        //search four directions for the current cell
        for (int[] d : directions) {
            //get the new row and new column number
            int nr = r + d[0], nc = c + d[1];
            
            //perform dfs on the new cell if it's within bounds and it's false (we haven't visited before) and its height >= current height
            if (nr >= 0 && nr < board.length && 
                nc >= 0 && nc < board[0].length && 
                board[nr][nc] == 'O') {
                dfs(nr, nc, board);
            }
        }
    }
}
