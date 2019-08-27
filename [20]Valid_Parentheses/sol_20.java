import java.util.Stack;

public class sol_20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch: s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            if (ch == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
            if (ch == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
            if (ch == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
