class Solution {
    public boolean canJump(int[] nums) {
        //It initializes a variable goal to the index of the last element in the array
        int goal = nums.length - 1;

        //The code iterates backward through the array, starting from the second-to-last element (nums.length - 2) down to the first element (index 0).
        //The idea is to check from right to left if any position can reach the current goal.
        for (int i = nums.length - 2; i >= 0; i--) {
            //If this farthest reachable index is greater than or equal to the current goal, it means that if you can reach position i, 
            //you can definitely reach the original goal.
            if (i + nums[i] >= goal) {
                goal = i;
            }
        }
        
        //After the loop finishes, if the goal variable has been updated to 0, 
        //it means that the starting position (index 0) can reach the (original) last index of the array.
        return goal == 0;
    }
}
