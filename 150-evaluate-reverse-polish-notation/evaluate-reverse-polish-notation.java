class Solution {
    public int evalRPN(String[] tokens) {
        Stack < Integer > stack = new Stack < > ();
        int a, b;
        for (String str: tokens) {
            switch (str) {
                case "+":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b + a);
                    break;
                case "-":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b - a);
                    break;
                case "*":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b * a);
                    break;
                case "/":
                    a = stack.pop();
                    b = stack.pop();
                    stack.push(b / a);
                    break;
                default:
                    stack.push(Integer.parseInt(str));
            }
        }
        System.out.print(stack);
        return stack.pop();
    }
}