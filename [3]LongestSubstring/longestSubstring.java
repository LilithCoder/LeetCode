import java.util.HashMap;
import java.util.Map;

// sliding window
public class longestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        int longestLength = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int left = 0, right = 0; right < length; right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right))+1);
            }

            longestLength = Math.max(longestLength, right-left+1);
            map.put(s.charAt(right), right);

        }
        return longestLength;
    }
}
