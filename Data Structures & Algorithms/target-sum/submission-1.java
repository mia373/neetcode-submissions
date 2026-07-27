class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // Target is out of range
        if (Math.abs(target) > sum) return 0;

        //create a 2D array where each column is the possible sum and each row means we can use numbers from index 0 to this index to calculate sum
        //total column number = maximum - minimum + 1 (1 means sum is 0)
        //given array starts at index 0, not minimum, we need an offset number which is - minimum
        int offset = sum;
        int[][] dp = new int[nums.length][2 * sum + 1];

        // Base case: when we can only use the first number, we can only get the sum equal to itself
        //There are two different ways to sum each number: -itself and +itself
        dp[0][nums[0] + offset]++;
        dp[0][-nums[0] + offset]++;

        for (int i = 1; i < nums.length; i++) {
            for (int s = -sum; s <= sum; s++) {
                //Make sure to convert sum into index number (array is 0-indexed)
                int idx = s + offset;
                
                //If we can use the first i-1 numbers to get a sum equal to s
                //Then we can use the first i numbers to get a sum equal to s+nums[i] or s-nums[i]
                if (dp[i - 1][idx] > 0) {
                    dp[i][idx + nums[i]] += dp[i - 1][idx];
                    dp[i][idx - nums[i]] += dp[i - 1][idx];
                }
            }
        }

        //Make sure add the offset to target
        return dp[nums.length - 1][target + offset];
    }
}
