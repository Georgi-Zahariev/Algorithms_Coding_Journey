public class PacificAtlanticWaterFlow {
    int ROWS;
    int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length;
        COLS = heights[0].length;

        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];

        for(int c = 0; c < COLS; c++){
            dfs(0, c, pac, heights, 0);
            dfs(ROWS - 1, c, atl, heights,0);
        }
        for(int r = 0; r < ROWS; r++){
            dfs(r, 0, pac, heights,0);
            dfs(r, COLS - 1, atl, heights,0);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(pac[r][c] && atl[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] ocean, int[][] heights, int prevH){
        if(r < 0 || r == ROWS || c < 0 || c == COLS || ocean[r][c] == true || heights[r][c] < prevH){
            return;
        }
        ocean[r][c] = true;

        dfs(r + 1, c, ocean, heights, heights[r][c]);
        dfs(r - 1, c, ocean, heights, heights[r][c]);
        dfs(r, c + 1, ocean, heights, heights[r][c]);
        dfs(r, c - 1, ocean, heights, heights[r][c]);
    }
}