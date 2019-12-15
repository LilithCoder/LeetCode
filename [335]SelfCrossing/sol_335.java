package LeetCode;

public class sol_335 {
    public boolean isSelfCrossing(int[] x) {
        // https://www.programcreek.com/2015/03/leetcode-self-crossing-java/
        // https://www.cnblogs.com/grandyang/p/5216856.html
        if (x.length < 3) {
            return false;
        }
        for (int i = 3; i < x.length; i++) {
            // situation1:fourth line cross first line;like a rectangle
            if (x[i] >= x[i -2] && x[i - 3] >= x[i - 1]) {
                return true;
            }
            // situation2:fifth line meet first line;like a rectangle
            if (i >= 4 && x[i - 1] == x[i - 3] && x[i] + x[i - 4] >= x[i - 2]) {
                return true;
            }
            // situation3:sixth line cross first line;like a capital letter L
            if (i >= 5 && x[i-5]<=x[i-3] && x[i]<=x[i-2]&& x[i-1]<=x[i-3] && x[i-4]<=x[i-2] && x[i] + x[i - 4] >= x[i - 2] && x[i - 5] + x[i - 1] >= x[i - 3]) {
                return true;
            }
        }
        return false;
    }
}
