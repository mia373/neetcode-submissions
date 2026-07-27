public class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        Arrays.sort(coins);
        
        //Row is the number of coins + 1. It represents the starting index for coins we can use for combination
        //Column is amount + 1. It represents the total amount from 0 to target amount.
        int[][] dp = new int[n + 1][amount + 1];

        //To make up 0 amount, there's one way for each coin starting index
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        //Iterate backwards. Start with the largest coin
        for (int i = n - 1; i >= 0; i--) {
            //Solve the smaller problem first
            for (int a = 0; a <= amount; a++) {
                //Only solve the problem when target anmount >= coin amount
                //No point to check the combinations of 2 and 5 to make up 1
                if (a >= coins[i]) {
                    //Because i means the starting index for coins we can use for combination. 
                    //If i+1 is valid combination, then i must be valid too (coins with starting index i include coins with starting index i+1)
                    dp[i][a] = dp[i + 1][a];
                    
                    //Also, if coins with starting index i will make up target - current coin, then it can make up target too
                    dp[i][a] += dp[i][a - coins[i]];
                }
            }
        }

        //Returns the combinations of coins starting at index 0 to make up the target amount
        return dp[0][amount];
    }
}