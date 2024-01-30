// class Solution {
//     public int evalRPN(String[] tokens) {
//         Stack < Integer > stack = new Stack < > ();
//         int a, b;
//         for (String str: tokens) {
//             switch (str) {
//                 case "+":
//                     a = stack.pop();
//                     b = stack.pop();
//                     stack.push(b + a);
//                     break;
//                 case "-":
//                     a = stack.pop();
//                     b = stack.pop();
//                     stack.push(b - a);
//                     break;
//                 case "*":
//                     a = stack.pop();
//                     b = stack.pop();
//                     stack.push(b * a);
//                     break;
//                 case "/":
//                     a = stack.pop();
//                     b = stack.pop();
//                     stack.push(b / a);
//                     break;
//                 default:
//                     stack.push(Integer.parseInt(str));
//             }
//         }
//         System.out.print(stack);
//         return stack.pop();
//     }
// }

class Solution {
    int pos;
    public int evalRPN(String[] tokens) {
        this.pos = tokens.length-1;
        return evaluate(tokens);
    }

    public int evaluate(String[] t){
        String token = t[pos];
        pos--;
        if(token.equals("+")){
            return evaluate(t) + evaluate(t); 
        }else
        if(token.equals("*")){
            return evaluate(t) * evaluate(t);
        }else 
        if(token.equals("-")){
            return -evaluate(t) + evaluate(t);
        }else
        if(token.equals("/")){
            int right = evaluate(t);
            return evaluate(t) / right;
        }else{
            return Integer.parseInt(token);
        }
    }
}