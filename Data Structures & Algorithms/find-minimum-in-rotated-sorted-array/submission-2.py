class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1

        while l < r:
            m = l + (r - l) // 2

            #the right half is a sorted segment. minimal element is in the left half or middle
            if nums[m] < nums[r]:
                r = m
            #the left half is a sorted segment. minimal element is in the right half
            else: 
                l = m + 1
        
        return nums[l]