package LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class sol_909 {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        // convert the 2d array to 1d array
        int[] flattenedArray = new int[n * n];
        boolean leftToRight = true;
        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (leftToRight) {
                    flattenedArray[index++] = board[i][j];
                } else {
                    flattenedArray[index++] = board[i][n - 1 - j];
                }
            }
            leftToRight = !leftToRight;
        }
        int targetIndex = n * n - 1;
        Queue<Integer> queue = new LinkedList<>();
        // keep track of which node have been visited
        boolean[] visited = new boolean[n * n];
        // keep track of number of moves
        int moves = 0;
        int startIndex = flattenedArray[0] == -1 ? 0 : flattenedArray[0] - 1;
        queue.offer(startIndex);
        visited[startIndex] = true;
        // bfs
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int currentIndex = queue.poll();
                if (currentIndex == targetIndex) {
                    return moves;
                }
                for (int j = 1; j <= 6; j++) {
                    int nextIndex = currentIndex + j;
                    if (nextIndex <= targetIndex) {
                        int destIndex = flattenedArray[nextIndex] == -1 ? nextIndex : flattenedArray[nextIndex] - 1;
                        if (visited[destIndex] == true) continue;
                        queue.add(destIndex);
                        visited[destIndex] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}
