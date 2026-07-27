class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1

        while l <= r:
            m = l + (r - l) // 2

            if target == nums[m]:
                return m
            
            #check if the right segment is sorted
            elif nums[m] <= nums[r]:
                #check if target is within the right segment
                if target > nums[m] and target <= nums[r]:
                    l = m + 1
                else:
                    r = m - 1
            #otherwise the left segment is sorted
            else:
                #check if target is within the left segment
                if target < nums[m] and target >= nums[l]:
                    r = m - 1
                else:
                    l = m + 1

        return -1