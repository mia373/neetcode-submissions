class Solution {
    public int coinChange(int[] coins, int amount) {
        //This value is used as an "infinity" placeholder. If we can't make a certain amount, we'll store max in our dp array, signifying that it's currently unreachable or requires more coins than the amount itself (which is impossible for a valid solution).
        int max = amount + 1;
        
        //This creates a dp (dynamic programming) array of size amount + 1. dp[i] will store the minimum number of coins required to make the sum i.
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
				
		//This is the base case. To make an amount of 0, you need 0 coins.
        dp[0] = 0;

//This outer loop iterates from 1 up to the amount. i represents the current amount we are trying to make.
//This inner loop iterates through each coin denomination in the coins array.
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                //This condition checks if the current coin coins[j] can be used to make the current amount i. If the coin's value is greater than the current amount, it cannot be used.
                if (coins[j] <= i) {
//If we use the current coin coins[j], then the number of coins needed to make amount i would be 1 (for the current coin) plus the minimum coins needed to make the remaining amount (i - coins[j]).
//We compare the current value of dp[i] (which might be max or a previously calculated minimum) with the new possibility (dp[i - coins[j]] + 1). We take the minimum of these two values, effectively finding the most efficient way to make amount i.
                dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
 
 //If dp[amount] is still max (which was initialized to amount + 1), it means that the amount could not be made using the given coins. In this case, the code returns -1.       
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
