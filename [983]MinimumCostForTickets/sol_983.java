package LeetCode;

public class sol_983 {
    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0 || costs == null || costs.length == 0) {
            return 0;
        }
        boolean[] travelDay = new boolean[366];
        for (int day: days) {
            travelDay[day] = true;
        }
        int[] dp = new int[366];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            if (travelDay[i] == true) {
                int day1 = costs[0] + dp[Math.max(i - 1, 0)];
                int day7 = costs[1] + dp[Math.max(i - 7, 0)];
                int day30 = costs[2] + dp[Math.max(i - 30, 0)];
                dp[i] += Math.min(day1, Math.min(day7, day30));
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[365];
    }
}
