class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // Target is out of range
        if (Math.abs(target) > sum) return 0;

        int offset = sum;
        int[][] dp = new int[nums.length][2 * sum + 1];

        // Base case
        dp[0][nums[0] + offset]++;
        dp[0][-nums[0] + offset]++;

        for (int i = 1; i < nums.length; i++) {
            for (int s = -sum; s <= sum; s++) {
                int idx = s + offset;
                if (dp[i - 1][idx] > 0) {
                    dp[i][s + nums[i] + offset] += dp[i - 1][idx];
                    dp[i][s - nums[i] + offset] += dp[i - 1][idx];
                }
            }
        }

        return dp[nums.length - 1][target + offset];
    }
}
