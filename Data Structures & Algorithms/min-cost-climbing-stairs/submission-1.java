class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
    
        // Special cases
        if (n == 0) return 0;
        if (n == 1) return cost[0];
        
        // dp[i] represents the minimum cost to reach the ith step
        int[] dp = new int[n + 1];
        
        // Base cases: we can start from either step 0 or step 1
        dp[0] = 0;
        dp[1] = 0;
        
        // Fill dp array bottom up
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        
        // Return the minimum cost to reach the top (beyond the last step)
        return dp[n];
    }
}