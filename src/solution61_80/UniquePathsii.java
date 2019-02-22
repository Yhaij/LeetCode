package solution61_80;

/**
 * @Author: yhj
 * @Description: dp问题，当这个位置为1时，则到达该点路径为0，否则加上其上和左的条数
 * @Date: Created in 2019/2/20.
 */
public class UniquePathsii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0){
            return 0;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        int[][] grid = new int[m][n];
        grid[0][0] = 1;
        for(int i = 1;i < m;i++){
            if(obstacleGrid[i][0] == 1){
                grid[i][0] = 0;
            }else {
                grid[i][0] = grid[i-1][0];
            }
        }
        for(int i = 1;i < n;i++){
            if(obstacleGrid[0][i] == 1){
                grid[0][i] = 0;
            }else {
                grid[0][i] = grid[0][i-1];
            }
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(obstacleGrid[i][j] == 1){
                    grid[i][j] = 0;
                }else {
                    grid[i][j] = grid[i-1][j] + grid[i][j-1];
                }
            }
        }
        return grid[m-1][n-1];
    }
}
