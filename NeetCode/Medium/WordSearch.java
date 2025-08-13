public class WordSearch {
    private int ROWS, COLS;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        visited = new boolean[ROWS][COLS];

        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(backtrack(board, word, r, c, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backtrack(char[][] board, String word, int row, int col, int index){
        if(index == word.length()){
            return true;
        }

        if(row < 0 || col < 0 || row == ROWS || col == COLS || board[row][col] != word.charAt(index) || visited[row][col] == true){
            return  false;
        }

        boolean result = false;

        visited[row][col] = true;
        result = backtrack(board, word, row, col + 1, index + 1) || 
                 backtrack(board, word, row, col - 1, index + 1) || 
                 backtrack(board, word, row + 1, col, index + 1) || 
                 backtrack(board, word, row - 1, col, index + 1);

        visited[row][col] = false;

        return result;
    }
}
