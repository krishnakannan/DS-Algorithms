class Solution {
    int total = 0;
    Stack<Integer> stack;
    public int calPoints(String[] ops) {
        stack = new Stack<>();
        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("C")) {
                int popped = stack.pop();
                total -= popped;
            } else if (ops[i].equals("D")) {
                int top = stack.peek();
                total += 2 * top;
                stack.push(2 * top);
            } else if (ops[i].equals("+")) {
                int top = stack.pop();
                int sTop = stack.pop();
                stack.push(sTop);
                stack.push(top);
                stack.push(top + sTop);
                total += top + sTop;                
            } else {
                int current = Integer.parseInt(ops[i]);
                stack.push(current);
                total += current;
            }
        }
        return total;
    }
}