class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;

        Queue<String> q = new LinkedList<>();
        Set<String> visit = new HashSet<>();
        int res = 1;

        q.add(beginWord);
        visit.add(beginWord); 

        while (!q.isEmpty()) {
            int size = q.size(); 
            res++;
            
            for (int i = 0; i < size; i++) {
                String node = q.poll();

                for (String s : wordList) {
                    if (!visit.contains(s) && canTransform(node, s)) {
                        if (s.equals(endWord)) {
                            return res;
                        }
                        visit.add(s);
                        q.add(s);
                    }
                }
            }
        }
        return 0;
    }


    private boolean canTransform (String word1, String word2) {
        if (word1.length() != word2.length()) return false;
        int diff = 0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return diff == 1;
    }
}