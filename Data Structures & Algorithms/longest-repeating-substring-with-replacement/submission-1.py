class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        count = {}
        res = 0
        l = 0
        maxf = 0

        for r in range(len(s)):  
            # maxf variable is the count of the most frequent letter in the window
            count[s[r]] = count.get(s[r], 0) + 1

            maxf = max(maxf, count[s[r]])
            
            # the condition checks invalid window (substring - max frequency > k)
            while (r - l + 1) - maxf > k:
                # move forward left pointer
                # and decrease its frequency by 1 in the hashmap
                # if left pointer is the most frequent letter, we don't need to decrement maxf. It won't affect res. 
                # res increments only when maxf increments. Because we compare res - maxf to a constant k. maxf增加了，k不变，res也会在增加.  
                count[s[l]] -= 1
                l += 1

            res = max(res, r - l + 1)
            
        return res
        