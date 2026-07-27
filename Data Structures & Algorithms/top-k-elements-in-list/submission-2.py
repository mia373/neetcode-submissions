class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count = {}

        #Initializes a list of lists
        #The size of freq is len(nums) + 1. This is because the maximum possible frequency 
        #of an element can be len(nums) (if all elements are the same). 
        freq = [[] for i in range(len(nums) + 1)]

        for num in nums:
            count[num] = 1 + count.get(num, 0)

        #For each num and its cnt, it appends the num to the list at index cnt in the freq list. 
        #This effectively groups numbers by their frequency.
        for num, cnt in count.items():
            freq[cnt].append(num)
        
        res = []

        #Iterates through the freq list from right to left (from highest frequency to lowest frequency).
        #range(len(freq) - 1, 0, -1) ensures this reverse iteration, starting from the maximum possible frequency down to 1
        for i in range(len(freq) - 1, 0, -1):
            #If freq[i] is an empty list ([]): The inner loop for num in freq[i]: will not execute even once. 
            #There are no elements (num) to iterate over within an empty list. 
            for num in freq[i]:
                res.append(num)

                if len(res) == k:
                    return res