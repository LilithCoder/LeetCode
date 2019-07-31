public class Solution5 {
    public static String longestPalindrome(String s) {

        if(s == null || s.length() == 0) return s;

        // dynamic programming
        boolean[][] dp = new boolean[s.length()][s.length()];

        String resultStr = "";

        int maxLength = 0;

        //in order to represent a substring, you need a starting index and a ending index
        //traverse all substring of string s
        for(int end = 0; end < s.length(); end++){
            for(int start = 0; start <= end; start++){

                int lengthOfSubstring = end - start + 1;

                //considering the base case, first initialize the one and two letters palindromes
                if(end - start == 0){
                    dp[start][end] = true;

                }
                if (end - start == 1 && (s.charAt(start) == s.charAt(end))){
                    dp[start][end] = true;

                }
                if(end - start >= 2){
                    //in this situation, the substring is at least of length three letters.
                    dp[start][end] = (s.charAt(start) == s.charAt(end)) && dp[start + 1][end - 1];
                }

                if(dp[start][end]){
                    if(lengthOfSubstring > maxLength){
                        maxLength = lengthOfSubstring;
                        resultStr = s.substring(start, end + 1);
                    }
                }
            }
        }
        return resultStr;
    }

    public static void main (String[] args){
        String testStr = "babad";
        System.out.println(Solution5.longestPalindrome(testStr));
    }
}
