public class sol_96_dp {
    /**
     *                G(3)
     *           /     |      \
     *      F(1,3)   F(2,3)   F(3,3)
     *      /  |      |   \    |   \
     *   G(0)G(2)   G(1) G(1) G(2) G(0)
     *
     *   G (n) = F(1, n) + F(2, n) + ... + F(n, n)
     *
     *  F(i, n) = G (i - 1) * G (n - i)
     *
     *
     *  G(n) = G(0)*G(n-1) + G(1)*G(n-2) + ... + G(n-1)*(0);
     *
     *
     */
    public int numTrees(int n) {
        // ith item in the dp indicates that number of unique structural BST given i nodes
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
