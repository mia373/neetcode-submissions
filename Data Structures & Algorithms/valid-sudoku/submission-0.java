class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> row = new HashSet<>();

            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {continue;}
                
                if (!row.add(board[i][j])) {
                    return false;
                }

                row.add(board[i][j]);
            }
        }

        for (int j = 0; j < board[0].length; j++) {
            HashSet<Character> column = new HashSet<>();

            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '.') {continue;}
                
                if (!column.add(board[i][j])) {
                    return false;
                }

                column.add(board[i][j]);
            }
        }

        for (int square = 0; square < 9; square++) {
            HashSet<Character> box = new HashSet<>();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int column = (square % 3) * 3 + j;

                    if (board[row][column] == '.') {continue;}
                    
                    if (!box.add(board[row][column])) {
                        return false;
                    }

                    box.add(board[row][column]);
                }
            }
        }

        return true; 
    }
}
