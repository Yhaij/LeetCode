package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/02.
 */
public class IargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        if(heights == null || heights.length == 0){
            return 0;
        }    
        int[][] p = new int[heights.length][heights.length];
        int[][] m = new int[heights.length][heights.length];
        for(int i = 0;i < heights.length;i++){
            p[i][i] = heights[i];
            m[i][i] = heights[i];
        }
        for(int i = 1;i < heights.length;i++){
            for(int j = i-1;j >= 0;j--){
                p[i][j] = Math.min(p[i-1][j], p[i][j+1]);
            }
        }

        for(int i = 1; i < heights.length;i++){
            for(int j = i-1; j >= 0;j--){
                m[i][j] = Math.max(Math.max(m[i-1][j], m[i][j+1]), p[i][j]*(i-j+1));
            }
        }
        return m[heights.length-1][0];
    }
}
