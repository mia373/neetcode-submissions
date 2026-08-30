class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        # max count of a single number
        n = len(nums)

        # we don't use 0 count. so we should create an array of length (n + 1)
        count = [[] for i in range(n + 1)]

        countMap = {}

        for num in nums:
            countMap[num] = countMap.get(num, 0) + 1
        
        for num, cnt in countMap.items():
            count[cnt].append(num)

        res = []

        # looping from index n to 0 backward 1 step at each time
        for i in range(n, -1, -1):     
            for num in count[i]:
                res.append(num)
                
                if len(res) == k:
                    return res
