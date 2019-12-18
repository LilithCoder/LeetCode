package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class sol_937 {
    public String[] reorderLogFiles(String[] logs) {
        if (logs == null)
            return new String[0];

        Arrays.sort(logs, new LogComparator());
        return logs;
    }
}
class LogComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        String[] s1Parts = s1.split(" ");
        String[] s2Parts = s2.split(" ");

        char s1FirstChar = s1Parts[1].charAt(0);
        char s2FirstChar = s2Parts[1].charAt(0);

        //if both are digit logs
        if (Character.isDigit(s1FirstChar) &&
                Character.isDigit(s2FirstChar)) {
            return 0 ; //return in order received
        }
        //if both are letter logs
        if (!Character.isDigit(s1FirstChar) &&
                !Character.isDigit(s2FirstChar)) {
            //compare substring after identifier and space
            String log1 = s1.substring(s1Parts[0].length() + 1);
            String log2 = s2.substring(s2Parts[0].length() + 1);

            int result = log1.compareTo(log2);
            //if substrings are identical, compare the identifiers
            return result != 0 ? result : s1Parts[0].compareTo(s2Parts[0]);
        }

        //one digit and other letter log
        return Character.isDigit(s1FirstChar) ? 1 : -1;
    }
}