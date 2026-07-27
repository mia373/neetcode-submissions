class Solution {
    public int rob(int[] nums) {
        int pre2 = 0, pre1 = 0;

        //dp[i] = max(dp[i-2] + nums[i], dp[i-1])
        //when i = nums.length - 1, dp[i] is the max amount of money I can rob
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }

        return pre1;
    }
}
