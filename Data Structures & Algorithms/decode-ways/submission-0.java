class Solution {
    public int numDecodings(String s) {
        //a digit (except 0) can be decoded as a single digit number
        //Or a digit can be decoded as a two-digit number with the next digit (between 10 and 26)
        //dp[i] = dp[i+1] + dp[i+2])
        
        //This extra space is crucial because dp[i] will store the number of ways to decode the substring s[i...s.length()-1]. 
        //The +1 allows dp[s.length()] to represent the base case.
        int[] dp = new int[s.length() + 1];

        //This is the base case. dp[s.length()] represents the number of ways to decode an empty string (the substring after the last character). 
        //There's only one way to decode an empty string (by doing nothing), so it's initialized to 1.
        dp[s.length()] = 1;

        //The loop iterates backward from the second-to-last character (s.length() - 1) down to the first character (0). 
        //This is typical for dynamic programming problems where the solution for a larger subproblem depends on solutions for smaller subproblems.
        for (int i = s.length() - 1; i >= 0; i--) {
            //If the current character s.charAt(i) is '0', it means this digit cannot be decoded on its own (since '0' is not a valid mapping).
            if (s.charAt(i) == '0') {
                dp[i] = 0;
            } else {
                //This line accounts for the case where s.charAt(i) is decoded as a single digit. 
                //The number of ways to decode from i would then be the same as the number of ways to decode the remaining substring starting from i+1.
                dp[i] = dp[i + 1];
                
                //This if condition checks if the current character s.charAt(i) and the next character  
                //s.charAt(i + 1) can form a valid two-digit number (between 10 and 26, inclusive).
                if (i + 1 < s.length() && (s.charAt(i) == '1' || 
                    s.charAt(i) == '2' && s.charAt(i + 1) < '7')) {
                    
                    //If a valid two-digit number can be formed, it means we can decode s.charAt(i) and s.charAt(i + 1) together. 
                    dp[i] += dp[i + 2];
                }
            }
        }

        return dp[0];
    }
}
