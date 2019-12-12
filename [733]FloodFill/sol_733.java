package LeetCode;

public class sol_733{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image[sr][sc] == newColor) {
            return image;
        }
        dfs(image, sr, sc, newColor, image[sr][sc]);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int newColor, int startingPixelColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[i].length || image[i][j] != startingPixelColor) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i + 1, j, newColor, startingPixelColor);
        dfs(image, i - 1, j, newColor, startingPixelColor);
        dfs(image, i, j + 1, newColor, startingPixelColor);
        dfs(image, i, j - 1, newColor, startingPixelColor);
    }
}
