package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class sol_1091 {
    public final int[][] directions = new int[][]{{0, 1}, {0, -1},  {1, 0},  {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) {
            return -1;
        }
        int lengthOfShortestPath = 0;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                if (current[0] == m - 1 && current[1] == n - 1) {
                    return lengthOfShortestPath + 1;
                }
                for (int[] dir: directions) {
                    int nextX = current[0] + dir[0];
                    int nextY = current[1] + dir[1];
                    if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && grid[nextX][nextY] == 0 && !visited[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new int[]{nextX, nextY});
                    }
                }
            }
            lengthOfShortestPath++;
        }
        return -1;
    }
}
