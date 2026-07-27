class Solution:
    def longestConsecutive(self, nums: List[int]) -> int:
        numSet = set(nums)
        longest = 0

        for num in numSet:
            #check if num is the beginning of a consecutive string
            if (num - 1) not in numSet:
                length = 1

                #compute the maximum possible consecutive string starts with num
                while (num + length) in numSet:
                    length += 1

                longest = max(length, longest)

        return longest
