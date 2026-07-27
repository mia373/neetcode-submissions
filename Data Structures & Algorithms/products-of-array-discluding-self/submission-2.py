class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        res = [0] * len(nums)
        
        #iterate nums from left to right and compute each num's prefix in the res list
        prefix = 1
        for i in range(len(nums)):
            res[i] = prefix
            prefix *= nums[i]
        
        #iterate nums from right to left and compute each num's postfix in the res list
        postfix = 1
        
        #loop from i = len(nums) - 1 to i = 0 (backward)
        for i in range(len(nums) - 1, -1, -1):
            res[i] *= postfix
            postfix *= nums[i]

        return res