class TrieNode {
    Map<Character, TrieNode> children;
    boolean isWord;

    public TrieNode() {
        children = new HashMap<>();
        isWord = false;
    }

    public void addWord(String word) {
        TrieNode cur = this;
        for (char c : word.toCharArray()) {
            cur.children.putIfAbsent(c, new TrieNode());
            cur = cur.children.get(c);
        }
        cur.isWord = true;
    }
}

public class Solution {
    private Set<String> res;
    private boolean[][] visit;
    
    public List<String> findWords(char[][] board, String[] words) {
        //Iterates through the words array and adds each word to the Trie using root.addWord().
        TrieNode root = new TrieNode();
        for (String word : words) {
            root.addWord(word);
        }

        int ROWS = board.length, COLS = board[0].length;
        
        //A HashSet to store the found words, preventing duplicates.
        res = new HashSet<>();
        
        //Initializes the visit array
        visit = new boolean[ROWS][COLS];

        //Iterates through each cell of the board and calls the dfs function to start the search from that cell
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                dfs(board, r, c, root, "");
            }
        }

        //Finally, returns the found words as a List (pass in the hashset)
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, String word) {
        int ROWS = board.length, COLS = board[0].length;
        
        //ase Cases: Returns if the current cell is out of bounds, already visited, 
        //or if there's no corresponding child in the Trie for the current character.
        if (r < 0 || c < 0 || r >= ROWS || 
            c >= COLS || visit[r][c] || 
            !node.children.containsKey(board[r][c])) {
            return;
        }

        //Marks the current cell as visited 
        visit[r][c] = true;
        
        //Moves to the child node in the Trie corresponding to the current character
        node = node.children.get(board[r][c]);
        
        //Appends the current character to the word being built.
        //String allows us to append character by using +=
        word += board[r][c];
        
        //If the current Trie node node marks the end of a word (node.isWord), the word is added to the res set.
        if (node.isWord) {
            res.add(word);
        }

        //Recursively calls dfs for the four neighboring cells (up, down, left, right).
        dfs(board, r + 1, c, node, word);
        dfs(board, r - 1, c, node, word);
        dfs(board, r, c + 1, node, word);
        dfs(board, r, c - 1, node, word);

        //Backtracking: Importantly, it resets the visit[r][c] to false after exploring the neighbors. 
        //This allows other paths to potentially use this cell.
        visit[r][c] = false;
    }
}
