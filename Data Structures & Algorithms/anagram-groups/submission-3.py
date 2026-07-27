class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
       # This will store our grouped anagrams.
       # When you try to access a key that doesn't exist yet: Instead of raising a KeyError (which a regular dict would do), defaultdict(list) will automatically call the list constructor (the function you passed in defaultdict(list)), create an empty list [] and return that new empty list.
        res = defaultdict(list) 

        for s in strs:
            # Create a count array for the current string 's'.
            count = [0] * 26 
            
            # Iterate through each character 'c' in the string 's'.
            for c in s:
            # Subtracting them gives a 0-based index (0 for 'a', 1 for 'b', etc.)
                count[ord(c) - ord('a')] += 1

            # Use the character count tuple as the key in our 'res' dictionary.
            # Convert the 'count' list to a tuple because lists are mutable and cannot be used as dictionary keys,
            # whereas tuples are immutable and can be.
            # Append the current string 's' to the list associated with this character count tuple.
            res[tuple(count)].append(s)
          
        # After processing all strings, 'res' will contain groups of anagrams.
        # We only need the values (the lists of strings), so we convert the dictionary's values to a list.
        return list(res.values())