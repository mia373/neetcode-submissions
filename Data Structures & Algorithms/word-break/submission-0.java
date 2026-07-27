class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //create an array for memoization 
        //at each index, true means we successfully found a word that matches a substring starting from the index
        //and we previously found words that match substrings after this substring
        //false means we cannot find any word that meet the above conditions
        boolean [] dp = new boolean[s.length() + 1];
        
        //base case: index at one position right after the string length is true
        dp[s.length()] = true; 


        //iterate from the end of string to the begining of string (bottom-up)
        for (int i = s.length() - 1; i >= 0; i--) {
            //iterate each word string in the dictionary
            for (String word: wordDict) {
                //if there are enough length starting from index i and there's a substring starting at index i matches with the word
                if (i + word.length() <= s.length() && s.substring(i, i + word.length()).equals(word)) {
                    //set the boolean the same as the previous boolean
                    //this is to make sure we previously found words that match substrings after this substring 
                    dp[i] = dp[i + word.length()];   
                }

                //if dp[i] is true, we found a perfect word, break the loop. decrement i by 1 
                if (dp[i]) {
                    break; 
                }
            }
        }

        return dp[0];

    }
}
