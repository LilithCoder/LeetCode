package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class sol_345 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('A');
        vowels.add('a');
        vowels.add('E');
        vowels.add('e');
        vowels.add('I');
        vowels.add('i');
        vowels.add('O');
        vowels.add('o');
        vowels.add('U');
        vowels.add('u');

        //Java string is immutable
        char[] charArray = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        // time complexity is still O(n)
        while (start < end) {
            while (start < end && !vowels.contains(charArray[start])) {
                start++;
            }
            while (start < end && !vowels.contains(charArray[end])) {
                end--;
            }
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
        return new String(charArray);
    }
}
