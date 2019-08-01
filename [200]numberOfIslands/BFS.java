import java.util.LinkedList;
import java.util.Queue;

//        Linear scan the 2d grid map,
//        if a node contains a '1', then it is a root node that triggers a Breadth First Search.
//        Put it into a queue and set its value as '0' to mark as visited node.
//        Iteratively search the neighbors of enqueued nodes until the queue becomes empty.
public class BFS {
    class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }

        int numOfIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++) {
                if(grid[i][j] == '1'){
                    bfs(grid, i, j, rows, cols);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private void bfs (char[][] grid, int x, int y, int rows, int cols) {

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<Coordinate> tempUnchanged = new LinkedList<>();
        tempUnchanged.add(new Coordinate(x, y));

        grid[x][y] = '0';

        // if there is a '1' (land), then add it to the queue(unchanged)
        // change it to '0', check its 4 neighbour, if '1', add it to the queue util all 4 neighbours have been traversed
        // then queue is not empty, keep checking the neighbours of the first neighbour of the last level.
        // then keep going until all neighbours checked is changed all and the queue is empty
        while(!tempUnchanged.isEmpty()){
            Coordinate removedCoordinate = tempUnchanged.remove();

            for (int[] direction : directions){
                int neighbourX = removedCoordinate.x + direction[0];
                int neighbourY = removedCoordinate.y + direction[1];

                //if the neighbour is located inside the boundary
                if(neighbourX >= 0 && neighbourY >= 0 && neighbourX < rows && neighbourY < cols){
                    if(grid[neighbourX][neighbourY] == '1'){
                        grid[neighbourX][neighbourY] = '0';
                        tempUnchanged.add(new Coordinate(neighbourX, neighbourY));
                    }
                }
            }
        }
    }
}
