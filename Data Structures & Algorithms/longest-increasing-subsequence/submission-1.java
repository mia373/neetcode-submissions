class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        
        //base case: initialize every element of dp to 1, since every element on its own is technically an increasing subsequence.
        Arrays.fill(dp, 1);

        int res = 0;

        //dp[i] = max(dp[j] + 1) for all j where nums[i] < nums[j] and i < j
        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }

            res = Math.max(res, dp[i]);
        }

        return res;
    }
}