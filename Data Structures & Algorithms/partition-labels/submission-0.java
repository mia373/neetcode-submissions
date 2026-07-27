class Solution {
    public List<Integer> partitionLabels(String s) {
        //We store the last index of each character in a hash map or an array.
        Map<Character, Integer> lastIndex = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }
        
        List<Integer> res = new ArrayList<>();
        int size = 0, end = 0;
        
        //As we iterate through the string, treating each index as a potential start of a partition, 
        //we track the end of the partition using the maximum last index of the characters seen so far in the current partition.
        for (int i = 0; i < s.length(); i++) {
            size++;
            end = Math.max(end, lastIndex.get(s.charAt(i)));

            //When the current index reaches the partition’s end, we finalize the partition,
            //append its size to the output list, reset the size to 0
            if (i == end) {
                res.add(size);
                size = 0;
            }
        }
        
        return res;
    }
}
