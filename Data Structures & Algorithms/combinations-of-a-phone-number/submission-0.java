class Solution {
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits.isEmpty()) {
            return res;
        }

        backtrack(0, "", digits, res);

        return res; 
    }

    private void backtrack(int i, String curStr, String digits, List<String> res ) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];

        for (char c : chars.toCharArray()) {
            // Add current character and continue backtracking
            backtrack(i + 1, curStr + c, digits, res);
            // No need to remove the character as we're passing a new string each time
        }
    }
}
