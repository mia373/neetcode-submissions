class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        int res; 

        for (String str: tokens) {
            if (str.matches("-?[0-9]+")) {
                num.push(Integer.parseInt(str));
            } else if (str.equals("+")) {
                res = num.pop() + num.pop();
                num.push(res);
            } else if (str.equals("*")) {
                res = num.pop() * num.pop();
                num.push(res);
            } else if (str.equals("-")) {
                int first = num.pop();
                int second = num.pop();
                res = second - first;
                num.push(res);
            } else if (str.equals("/")) {
                int first = num.pop();
                int second = num.pop();
                res = second / first;
                num.push(res);
            }
        }

        return num.peek(); 
    }
}
