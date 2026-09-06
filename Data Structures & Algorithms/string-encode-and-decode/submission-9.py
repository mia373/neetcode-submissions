class Solution:

    def encode(self, strs: List[str]) -> str:
        res = ""
        for s in strs:
            res += str(len(s)) + '#' + s
        return res

    def decode(self, s: str) -> List[str]:
        res = []
        l = 0
        r = 0

        while r < len(s):         
            while s[r] != '#':
                r += 1

            # number of characters can be two digits so we can't use s[r - 1]
            length = int(s[l:r])
            substring = s[r + 1 : r + 1 + length]
            res.append(substring)
            r = r + length + 1
            l = r

        return res
