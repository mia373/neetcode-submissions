class Solution:
    def checkInclusion(self, s1: str, s2: str) -> bool:
        if len(s2) < len(s1):
            return False
        
        dict1 = {}
        dict2 = {}

        for i in range(len(s1)):
            dict1[s1[i]] = dict1.get(s1[i], 0) + 1
            dict2[s2[i]] = dict2.get(s2[i], 0) + 1
        
        l, r = 0, len(s1) - 1

        while r < len(s2):
            if dict1 == dict2:
                return True
            
            dict2[s2[l]] -= 1
            if dict2[s2[l]] == 0:
                del dict2[s2[l]]

            l += 1
            r += 1

            if r < len(s2):
                dict2[s2[r]] = dict2.get(s2[r], 0) + 1

        return False