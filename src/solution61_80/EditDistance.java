package solution61_80;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/26.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length()+1;
        int n = word2.length()+1;
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        int[][] d = new int[m][n];
        for(int i = 0;i < m;i++){
            d[i][0] = i;
        }
        for(int i = 0;i < n;i++){
            d[0][i] = i;
        }
        for(int i = 1;i < m;i++){
            for(int j = 1;j < n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1];
                }else {
                    d[i][j] = Math.min(Math.min(d[i-1][j], d[i][j-1]), d[i-1][j-1])+1;
                }
            }
        }
        return d[m-1][n-1];
    }
}
