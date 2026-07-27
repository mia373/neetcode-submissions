class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        if (s3.length() != s1.length() + s2.length()) {
            return false;
        }

        for (int i = 0; i <= s1.length(); i++){
            for (int j = 0; j <= s2.length(); j++){
                //Base Case 1: If we use 0 char from s1 and 0 char from s2 to construct 0+0 char of s3, return true
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                //Base Case 2: If we only use char from s1, we just need to check if curr char at s1 is the same as s3
                //Be mindful that curr char index = i - 1, not i
                } else if (j == 0) {
                    if (dp[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                        dp[i][j] = true;
                    } 
                //Base Case 3: If we only use char from s2, we just need to check if curr char at s2 is the same as s3
                //Be mindful that curr char index = j - 1, not j
                } else if (i == 0) {
                    if (dp[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                        dp[i][j] = true;
                    }
                //To check if we can use i char from s1 and j char from s2 to construct i+j char from s3, we will check
                //(1)If we can use i-1 char from s1 and j char from s2 to construct i+j-1 char from s3 and curr char at s1 is the same as s3
                //Or (2)If we can use i char from s1 and j-1 char from s2 to construct i+j-1 char from s3 and curr char at s2 is the same as s3
                } else {
                    if ((dp[i - 1][j] == true && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                    || (dp[i][j - 1] == true && s2.charAt(j - 1) == s3.charAt(i + j - 1))) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
