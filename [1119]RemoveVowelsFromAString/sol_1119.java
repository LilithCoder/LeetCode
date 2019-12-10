package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class sol_1119 {
    public String removeVowels(String S) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        StringBuilder sb = new StringBuilder();
        for (char c: S.toCharArray()) {
            if (!vowels.contains(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}
