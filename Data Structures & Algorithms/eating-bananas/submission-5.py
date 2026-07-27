class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        l, r = 1, max(piles)

        while l <= r:
            hour = 0
            m = l + (r - l) // 2
            
            for pile in piles:
                hour += math.ceil(pile / m)
            
            if hour <= h:
                res = m
                r = m - 1
            else:
                l = m + 1
        
        return res