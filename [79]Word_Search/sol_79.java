public class sol_79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++){
            for (int j = 0; j < board[i].length; j++){
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int index) {

        //the depth of dfs recursion is already the length of the target word, and the target word has been already found
        // then stop the recursion
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >=board[i].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        //store the board elements temporarily
        char temp = board[i][j];
        board[i][j] = ' ';

        // recursion
        boolean isFound = dfs(board, word, i + 1, j, index + 1) ||
                dfs(board, word, i - 1, j, index + 1) ||
                dfs(board, word, i , j + 1, index + 1) ||
                dfs(board, word, i , j - 1, index + 1);
        board[i][j] = temp;
        return isFound;
    }
}
