class Solution {
    //global variable: rows and columns' length
    private int ROWS, COLS;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;

        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                //if we find any valid path, return immediately
                if (dfs(board, word, r, c, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int r, int c, int i) {
        //base case: when index is right after word's length, we have found a valid path
        if (i == word.length()) {
            return true;
        }

        //when row and column are out of bounds, or letter in board doesn't match letter in word, or we've visited letter in board in path
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || 
            board[r][c] != word.charAt(i) || board[r][c] == '#') {
            return false;
        }

        //mark the letter as visited using #
        board[r][c] = '#';
        boolean res = dfs(board, word, r + 1, c, i + 1) ||
                      dfs(board, word, r - 1, c, i + 1) ||
                      dfs(board, word, r, c + 1, i + 1) ||
                      dfs(board, word, r, c - 1, i + 1);
        
        //unmark the letter as visited
        //when we proceed to this line of code, either we explored four directions and all returned false. this node is invalid. we should unmark the node
        //or we found a valid path. unmarking isn't necessary but it doens't harm
        board[r][c] = word.charAt(i);
        
        return res;
    }
}
