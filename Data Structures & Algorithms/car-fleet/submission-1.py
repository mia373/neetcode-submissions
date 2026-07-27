class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        #同速的追不上，快速的能追上慢速的车
        #Maintain a monotonically decreasing stack for speed for each fleet
        #Return the number of stacks
        pair = []
        for p, s in zip(position, speed):
            pair.append((p, s))
        
        #sort the car by the decreasing position order
        pair.sort(reverse = True)

        #store arrival time by monotonically decreasing order
        stack = []

        for p, s in pair:
            time = (target - p) / s
            if stack and time <= stack[-1]:
                continue
            else:
                stack.append(time)

        return len(stack)
