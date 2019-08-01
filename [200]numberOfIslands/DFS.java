public class DFS {
//    Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
//    Example 1:
//
//    Input:
//            11110
//            11010
//            11000
//            00000
//
//    Output: 1
//    Example 2:
//
//    Input:
//            11000
//            11000
//            00100
//            00011
//
//    Output: 3
    final static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    public static int numIslands(char[][] grid) {
        //sanity check
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int numOfIslands = 0;
        final int rows = grid.length;
        final int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                   numOfIslands++;
                   dfs(grid, i, j, rows, cols);
                }
            }
        }
        return numOfIslands;
    }

    private static void dfs(char[][] grid, int x, int y, int rows, int cols) {


        //base case
        if(x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == '0'){
            return;
        }
        //recursion
        grid[x][y] = '0';

        //traverse four surrounding, once one neighbour is land, then do dfs search recursively util there is no more land in this direction;
        for(int[] direction: directions){
            dfs(grid, x + direction[0], y + direction[1], rows, cols);
        }
    }

    public static void main(String[] args){
        char[][] grid = {{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}};
        System.out.println(numIslands(grid));
    }
}
