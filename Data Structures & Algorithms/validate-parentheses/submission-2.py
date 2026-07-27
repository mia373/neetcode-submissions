class Solution:
    def isValid(self, s: str) -> bool:
        pair_map = {')': '(', '}': '{', ']': '['}
        stack = []

        for c in s:
            if c in pair_map and stack:
                temp = stack.pop()
                if temp != pair_map.get(c):
                    return False
            else:
                stack.append(c)
        
        return not stack
