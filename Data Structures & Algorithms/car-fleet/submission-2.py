class Solution:
    def carFleet(self, target: int, position: List[int], speed: List[int]) -> int:
        pair = []
        for p, s in zip(position, speed):
            pair.append((p, s))
        
        #sort the car by the decreasing position order
        pair.sort(reverse = True)

        #store arrival time by monotonically increasing order
        stack = []

        for p, s in pair:
            time = (target - p) / s
            #If the current car's time is less than or equal to the top of the stack, it joins the same fleet. 
            if stack and time <= stack[-1]:
                continue
            #Otherwise, it forms a new fleet, and we push its time onto the stack
            else:
                stack.append(time)

        return len(stack)
