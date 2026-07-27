class Solution:
    def findDuplicate(self, nums: List[int]) -> int:
        slow, fast = 0, 0

        while True:
            slow = nums[slow]
            fast = nums[nums[fast]]
            #cycle detected
            if slow == fast:
                break

        slow2 = 0
        while True:
            slow = nums[slow]
            slow2 = nums[slow2]
            #They meet at the duplicate number
            if slow == slow2:
                return slow

