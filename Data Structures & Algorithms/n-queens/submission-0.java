class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();

        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        backtrack(0, board, res);
        return res;
    }

    private void backtrack(int r, char[][] board, List<List<String>> res) {
        if (r == board.length) {
            List<String> copy = new ArrayList<>();

            for (char[] row : board) {
                copy.add(new String(row));
            }

            res.add(copy);
            return; 
        }

        //Iterates through each column c in the current row r.
        for (int c = 0; c < board.length; c++) {
            //check if current row & column is safe
            if (isSafe(r, c, board)) {
                
                board[r][c] = 'Q';
                
                //move to the next row
                backtrack(r + 1, board, res);
                
                //backtrack
                board[r][c] = '.';
            }
        }
    }

    //every queen has to be in a different row and a different column
    //no two queens can appear in the same diagonal
    //Checks if placing a queen at (r, c) is safe by verifying that no other queen in previous rows attacks this position. 
    //It only needs to check previous rows because the backtrack function places queens row by row.
    private boolean isSafe(int r, int c, char[][] board) {
        for (int i = r - 1; i >= 0; i--) {
            if (board[i][c] == 'Q') return false;
        }
        for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        for (int i = r - 1, j = c + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }
}
