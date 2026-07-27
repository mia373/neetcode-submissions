class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prod, zero_cnt = 1, 0

        for num in nums:
            # 0 is considered falsy, so this means if num is not 0, we calculate the product
            if num:
                prod *= num
            else:
                zero_cnt += 1
        
        # if zero count > 1, then every product except itself is 0
        if zero_cnt > 1: return [0] * len(nums)

        # initialize a zero array
        res = [0] * len(nums)
        
        # for each (index, value) pair
        for i, c in enumerate(nums):
            # if zero count is not zero then there must be one zero
            # res[i] = 0 if c is not zero else res[i] = prod
            if zero_cnt: res[i] = 0 if c else prod
            
            # if zero count is zero
            else: res[i] = prod // c

        return res
        