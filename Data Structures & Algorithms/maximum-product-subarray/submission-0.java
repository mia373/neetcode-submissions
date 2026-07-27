class Solution {
    public int maxProduct(int[] nums) {
        // It's initialized with the first element of the array because a single element can be a subarray
        int res = nums[0];
        
        //curMin and curMax store the maximum and the minimum product of a subarray ending at the current position
        //We initialize them to 1 because multiplying by 1 won't change the product, allowing us to correctly start tracking products from the beginning of a subarray.
        int curMin = 1, curMax = 1;

        for (int num : nums) {
            //Since curMax is updated first, we need to save the value of curMax * num before curMax changes. This tmp variable will be used to calculate the new curMin.
            int tmp = curMax * num;
            
          //This line calculates the new curMax. It considers three possibilities
            //1. The product of the current number and the maximum product ending at the previous position
            //2. The product of the current number and the minimum product ending at the previous position. This is vital when num is negative, as multiplying by a negative curMin could turn it into a large positive number.
            //3. The current number itself. This handles cases where starting a new subarray from num gives a larger product than extending the previous ones (e.g., if previous products were 0 or very small).
            curMax = Math.max(Math.max(num * curMax, num * curMin), num);
            
     //This line calculates the new curMin. It also considers three possibilities
            curMin = Math.min(Math.min(tmp, num * curMin), num);
            
            //After updating curMax for the current position, we compare it with the overall maximum product found so far
            res = Math.max(res, curMax);
        }
        
        return res;
    }
}
