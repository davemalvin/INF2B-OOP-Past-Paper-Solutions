import java.util.Stack;

public class Balanced {
    public static boolean checkBalancedParanthesis(String s) {
        Stack<Character> stack = new Stack<>();
        char[] cs = s.toCharArray();
        for (char c : cs) {
            if (c=='(' || c=='[') {
                stack.push(c);
            } else if (c==')' || c==']') {
                if (stack.isEmpty()) {
                    return false;
                } 
                char last = stack.peek();
                if ((c==')' && last=='(') || (c==']' && last=='[')) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    
    public static void main(String[] args) {
        if (checkBalancedParanthesis(args[0])) {
            System.out.println("BALANCED!");
        } else {
            System.out.println("NOT BALANCED!");
        }
    }
}
