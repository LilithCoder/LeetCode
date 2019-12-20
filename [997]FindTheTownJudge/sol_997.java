package LeetCode;

public class sol_997 {
    public int findJudge(int N, int[][] trust) {
        // Consider trust as a graph, all pairs are directed edge.
        // The point with in-degree - out-degree = N - 1 become the judge.
        int[] nodes = new int[N + 1];
        for (int[] t: trust) {
            nodes[t[0]]--;
            nodes[t[1]]++;
        }
        for (int i = 1; i <= N; i++) {
            if (nodes[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
