class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        res = [0] * len(temperatures)
        stack = []  # pair: [temp, index]

        for i, t in enumerate(temperatures):
            # maintain a monotonically decreasing stack
            while stack and t > stack[-1][0]:
                # pop off the top tuple and store its index difference in the result array
                prev_temp, prev_index = stack.pop() 
                res[prev_index] = i - prev_index

            # always add current temp and index to the stack.
            stack.append((t, i))

        return res