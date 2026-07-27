class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int left = 0; left < s.length(); left++) {
            for (int right = left + 1; right <= s.length(); right++) {
                String sub = s.substring(left, right);
                if (isPalindromic(sub) && sub.length() > (end - start)) {
                    start = left;
                    end = right;
                }
            }
        }

        return s.substring(start, end);
    }

    public boolean isPalindromic(String substring) {
        int left = 0, right = substring.length() - 1;
        while (left < right) {
            if (substring.charAt(left++) != substring.charAt(right--)) {
                return false;
            }
        }
        return true;
    }
}
