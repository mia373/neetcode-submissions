class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;

        for (int i=0; i < s.length(); i++) {
            HashSet<Character> set = new HashSet<>();
            int j = i; 
            while (j < s.length() && set.add(s.charAt(j))) {
                j++; 
            }
            res = Math.max(res, j - i); 
        }

        return res; 
    }
}
