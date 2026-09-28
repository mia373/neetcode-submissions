class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        total_product = 1
        zero_count = 0
        res = [0] * len(nums)
        for num in nums:
            if num != 0:
                total_product *= num
            else:
                zero_count += 1

        for i, num in enumerate(nums):
            if num != 0 and zero_count == 0:
                res[i] = int(total_product / num)
            elif num == 0 and zero_count == 1:
                res[i] = total_product
            else:
                res[i] = 0

        return res
