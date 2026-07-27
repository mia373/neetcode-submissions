class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        stack = []
        res = []
        
        def backtrack(openN, closeN):
            # return result if openN == closedN == n
            # only add open parenthesis if openN < n
            # only add close parenthesis if closedN < openN
        
            if openN == closeN == n:
                res.append("".join(stack))
                return
            
            # tends to go "deeper" first by adding opening parentheses when possible
            # builds up opening parentheses before balancing with closing ones
            if openN < n:
                stack.append("(")
                backtrack(openN + 1, closeN)
                # pop the parenthesis we just added (backtrack)
                stack.pop()
            
            if closeN < openN:
                stack.append(")")
                backtrack(openN, closeN + 1)
                stack.pop()

        backtrack(0, 0)
        return res
