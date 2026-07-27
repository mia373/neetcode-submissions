class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();

        //the minimum distance for a string from 0 to l1 and a string from 0 to l2
        int[][] memo = new int[l1+1][l2+1];

        //if word2 is an empty string
        for (int i = 0; i <= l1; i++) {
            memo[i][0] = i;
        }

        //if word1 is an empty string
        for (int j = 0; j <= l2; j++) {
            memo[0][j] = j;
        }

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                int cost = word1.charAt(i-1) == word2.charAt(j-1) ? 0 : 1;
                memo[i][j] = Math.min(memo[i-1][j-1] + cost, Math.min(memo[i-1][j]+1, memo[i][j-1]+1));
            }
        }

        return memo[l1][l2];
    }
}