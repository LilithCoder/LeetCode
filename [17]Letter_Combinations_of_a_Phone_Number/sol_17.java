import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class sol_17 {
    // DFS
    // Tutorial: https://www.youtube.com/watch?v=uMmFXWs_ZMY
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        // corner case
        if (digits == null || digits.length() == 0) {
            return res;
        }
        // the current string combination
        StringBuilder sb = new StringBuilder();
        // the mapping between the digit and corresponding letters
        Map<Integer, String> mapping = new HashMap<>();
        mapping.put(0, "");
        mapping.put(1, "");
        mapping.put(2, "abc");
        mapping.put(3, "def");
        mapping.put(4, "ghi");
        mapping.put(5, "jkl");
        mapping.put(6, "mno");
        mapping.put(7, "pqrs");
        mapping.put(8, "tuv");
        mapping.put(9, "wxyz");
        dfsHelper(digits, 0, sb, mapping, res);
        return res;
    }

    private void dfsHelper(String digits, int index, StringBuilder sb, Map<Integer, String> mapping, List<String> res) {
        // base case: the next step has been beyond the leaf node of the tree
        if (index == digits.length()) {
            res.add(String.valueOf(sb));
            return;
        }
        // recursive rule
        // get the corresponding String of the digit
        String currValues = mapping.get(digits.charAt(index) - '0');
        for (char ch: currValues.toCharArray()) {
            sb.append(ch);
            dfsHelper(digits, index + 1, sb, mapping, res);
            // backtracking
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
