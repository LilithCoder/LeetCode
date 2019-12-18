package LeetCode;

import java.util.PriorityQueue;

public class sol_1102 {
    public int maximumMinimumPath(int[][] A) {
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int m = A.length;
        int n = A[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pqueue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pqueue.add(new int[]{0, 0, A[0][0]});
        // in each loop, the element in the pqueue are the smallest value of perspective paths
        // so we always poll the maximum in these minimum values
        while (!pqueue.isEmpty()) {
            int[] cell = pqueue.poll();
            int row = cell[0];
            int col = cell[1];
            if (row == m - 1 && col == n - 1) {
                return cell[2];
            }
            visited[row][col] = true;
            for (int[] dir: directions) {
                int nextRow = row + dir[0];
                int nextCol = col + dir[1];
                if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || visited[nextRow][nextCol]) continue;
                // keep track of the minimum value of each path
                pqueue.add(new int[]{nextRow, nextCol, Math.min(cell[2], A[nextRow][nextCol])});
            }
        }
        return -1;
    }
}
