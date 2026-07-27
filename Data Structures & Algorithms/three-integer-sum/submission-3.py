class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        res = []

        #iterate each index and value
        for i, a in enumerate(nums):
            # Early termination: if the smallest element is positive,
            # no way to get sum of 0
            if a > 0:
                break
            
            # Skip duplicates for the first element
            if i > 0 and a == nums[i - 1]:
                continue
            
            # Two-pointer approach for the remaining two elements
            l, r = i + 1, len(nums) - 1

            while l < r: 
                three_sum = nums[l] + nums[r] + a
                
                if three_sum == 0:
                    res.append([nums[l], nums[r], a])

                    # Skip duplicates for left pointer
                    while l < r and nums[l] == nums[l + 1]:
                        l += 1

                    # Skip duplicates for right pointer
                    while l < r and nums[r] == nums[r - 1]:
                        r -= 1
                    
                    l += 1
                    r -= 1

                elif three_sum > 0:
                    r -= 1
                else:
                    l += 1

        return res