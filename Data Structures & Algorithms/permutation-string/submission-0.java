class Solution {
    public boolean checkInclusion(String s1, String s2) {
        for (int l = 0; l + s1.length() - 1 < s2.length(); l++) {
            if (isPermutation(s1, s2.substring(l, l + s1.length()))) return true;

        }

        return false; 
    }

    public boolean isPermutation(String str1, String str2) {
        // If lengths are different, they cannot be permutations
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a frequency array for characters
        int[] charCount = new int[26]; // Assuming ASCII characters

        // Increment for str1 and decrement for str2
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i) - 'a']++;
            charCount[str2.charAt(i) - 'a']--;
        }

        // Check if all counts are zero
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
}
