class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            // If target is found
            if (nums[m] == target) return m;

            // Check if the left segment is sorted
            if (nums[l] <= nums[m]) {
                // Check if target lies within the left sorted segment
                if (target >= nums[l] && target < nums[m]) {
                    r = m - 1;
                } else {
                    l = m + 1;
                }
            } 
            // Otherwise, the right segment must be sorted
            else {
                // Check if target lies within the right sorted segment
                if (target > nums[m] && target <= nums[r]) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
        }

        // Target not found
        return -1;
    }
}