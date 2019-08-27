import java.util.ArrayList;
import java.util.List;

public class sol_301 {
    public static List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        helper(s, result, 0, 0, '(', ')');
        return result;
    }

    // using the concept of recursion util find all possible string whose right paren equals left paren
    private static void helper(String s, List<String> result, int iStart, int lastRemove, char openParen, char closeParen) {
        int numOpenParen = 0;
        int numCloseParen = 0;
        int size = s.length();

        for (int i = iStart; i < size; i++) {
            if (s.charAt(i) == openParen) numOpenParen++;
            if (s.charAt(i) == closeParen) numCloseParen++;
            // when extra right paren
            if (numCloseParen > numOpenParen) {
                // the concept of last remove is very important
                for (int j = lastRemove; j <= i; j++) {
                    // in order to avoid duplicate, we could remove the right paren
                    // only when the last paren does not equal to right paren
                    // remove the first ) in a series of consecutive )s.
                    if (s.charAt(j) == closeParen && (j == lastRemove || s.charAt(j - 1) != closeParen)) {
                        helper(s.substring(0, j) + s.substring(j + 1, size), result, i, j, openParen, closeParen);
                    }
                }
                return;
            }
        }

        // No invalid closed parenthesis detected. Now check opposite direction
        // when reversedStr is also right paren equals left paren, then this string is valid
        String reversedStr = new StringBuilder(s).reverse().toString();
        if (openParen == '(') {
            helper(reversedStr, result, 0,0, ')', '(');
        } else {
            result.add(reversedStr);
        }
    }

        public static void main(String[] args) {
            String test = "()()()))";
            System.out.println(removeInvalidParentheses(test));
        }

}


