class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (i + 1 < matrix.length && target >= matrix[i][0] && target < matrix[i+1][0]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) return true;
                }
            } else if (i == matrix.length - 1 && target >= matrix[i][0]) {
                for (int j = 0; j < matrix[i].length; j++) {
                    if (matrix[i][j] == target) return true;
                }
            }
        }

        return false; 
    }
}
