package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class sol_994 {
    public final int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return -1;
        }
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        // add all current rotten orange to the queue, this is the 1st minute(level)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int minute = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] rotten = queue.poll();
                for (int[] dir: directions) {
                    int nextX = rotten[0] + dir[0];
                    int nextY = rotten[1] + dir[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        queue.add(new int[] {nextX, nextY});
                    }
                }
            }
            minute++;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        // Imagine you are doing BFS on a tree,
        // starting from depth = 0, you do depth++ every level as you go down,
        // adding child nodes into the queue,
        // and when you reach the last level where all the nodes are null(for instance) you are still doing depth++
        return minute == 0 ? 0 : minute - 1;
    }
}
