class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) { // If on the first row or first column
                    dp[i][j] = 1;    // There's only one way to reach these cells
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1]; // Sum of paths from top and left
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
