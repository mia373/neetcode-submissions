class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        l = 0
        seen = set()
        res = 0

        for r in range(len(s)):
            if s[r] not in seen:
                seen.add(s[r])
                res = max(res, r - l + 1)
            else:
                while s[l] != s[r]:
                    seen.remove(s[l])
                    l += 1
                l += 1
        
        return res
