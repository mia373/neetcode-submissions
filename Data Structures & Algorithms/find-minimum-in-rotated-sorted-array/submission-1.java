class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;

        while (l < r) {
            int m = l + (r - l)/2;
            
            //it means that the right half from A[m] to A[r] are sorted in ascending order. 
            //Since A[m] is smaller than other elements from A[m + 1] to A[r], the minimum number cannot be in the range from A[m + 1] to A[r]
            if (nums[m] < nums[r]) {
                r = m; 
            //If A[m] ≥ A[r], it means that the right half from A[m] to A[r] are not sorted in ascending order. 
            //Since A[m] belongs to the larger segment [ai+1, . . . , an] that precedes a1, a1 must be to the right of A[m].
            } else {
                l = m + 1; 
            }
        }

		//The while loop terminates when l = r. At this point, we have found the index min=l=r for the minimum number. 
        //Return nums[l] or nums[r]. 
        return nums[l];
    }
}