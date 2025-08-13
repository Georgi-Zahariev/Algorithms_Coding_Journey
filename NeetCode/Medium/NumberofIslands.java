public class NumberofIslands {
    private static boolean[][] visited;
    public int numIslands(char[][] grid) {
        int result = 0;
        int rowCnt = grid.length;
        int colCnt = grid[0].length;
        visited = new boolean[rowCnt][colCnt];

        for(int i = 0; i < rowCnt; i++){
            for(int j = 0; j < colCnt; j++){
                if(grid[i][j] == '1' && visited[i][j]!= true){
                    dfs(grid, i,j);
                    result++;
                }
            }
        }

        return result;
    }

    static void dfs(char[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0' || visited[row][col])
            return;

        visited[row][col] = true;

        dfs(grid, row + 1, col);
        dfs(grid, row - 1, col);
        dfs(grid, row, col + 1);
        dfs(grid, row, col - 1);
    }
}
