class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        // only add open parenthesis if openN < n
        // only add close parenthesis if closedN < openN
        // return result if openN == closedN == n
        
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack (openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }

        if (closedN < openN) {
            stack.append(')');
            backtrack (openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
