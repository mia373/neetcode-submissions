class Solution {
    List<List<String>> res;

    public List<List<String>> partition(String s) {
        //When split the given string into substrings, we cannot change the order of characters
        //Think about s.substring(int start, int end). We're only allowed to split the string by starting and end indexes. 
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, part, res);
        return res;
    }

    public void dfs(int i, String s, List<String> part, List<List<String>> res){
        //The base condition to stop the recursion is when start index reaches the end of the string
        if (i >= s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++) {
            if (isPanlindromic(s.substring(i, j + 1))) {
                part.add(s.substring(i, j + 1));
                dfs (j + 1, s, part, res);
                part.remove(part.size() - 1);
            }
        }

    }

    public boolean isPanlindromic (String str) {
        int l = 0;
        int r = str.length() - 1;

        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) {
                return false;
            }
            l++; 
            r--;
        }
        return true;
    }
}
