public class Solution {
    public boolean canPartition(int[] nums) {
        //If the total sum is odd, it's impossible to divide the numbers into two subsets with equal sums.
        if (sum(nums) % 2 != 0) {
            return false;
        }

        //We only need to find a subset where sum is half of the total sum. 
        //Once we find it, the other subset automatically is half of the total sum.
        int target = sum(nums) / 2;

        //dp[j] will store true if a sum j can be formed using some numbers from the input array, and false otherwise.
        boolean[] dp = new boolean[target + 1];

        //dp[0] is initialized to true because a sum of 0 can always be achieved (by picking no elements).
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            //For each number, it iterates backward from target down to the current number (nums[i]). 
            //This backward iteration is crucial to ensure that each number is used at most once to form a particular sum.
            for (int j = target; j >= nums[i]; j--) {
                //This means that sum j can be achieved if:
                //It was already achievable without using the current number nums[i] (i.e., dp[j] was already true).
                //OR, if the sum j - nums[i] was achievable, and we now include the current number nums[i].
                dp[j] = dp[j] || dp[j - nums[i]];
            }
        }
        
        return dp[target];
    }

    //a helper function that returns the sum of its elements
    private int sum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }
}