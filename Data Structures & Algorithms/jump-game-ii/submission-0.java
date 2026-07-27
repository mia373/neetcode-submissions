public class Solution {
    public int jump(int[] nums) {
        //Do not initialize r = nums[0] and res = 1 directly
        //It won't pass the edge case nums=[0]. It will incorrectly return 1, but should return 0. 
        int res = 0, l = 0, r = 0; 

        while (r < nums.length - 1) {
            int farthest = 0;
            // This loop explores all options from the current reachable 'level' [l, r]
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;    // The next level starts from where the current one ended
            r = farthest; // The new 'r' is the farthest reach from the PREVIOUS level
            res++;        // Increment jump count because we've just defined a new level/jump
        }
        return res;
    }
}