package solution81_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/14.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length() != s1.length() + s2.length()){
            return false;
        }
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        char[] c3 = s3.toCharArray();
        boolean[][] p = new boolean[s1.length()+1][s2.length()+1];
        p[0][0] = true;
        for(int i = 1; i <= c1.length;i++){
            if(c1[i-1] == c3[i-1]){
                p[i][0] = p[i-1][0];
            }
        }
        for(int i = 1; i <= c2.length;i++){
            if (c2[i-1] == c3[i-1]){
                p[0][i] = p[0][i-1];
            }
        }

        for(int i = 1; i <= c1.length;i++){
            for (int j = 1;j <= c2.length;j++){
                if (c1[i-1] == c3[i+j-1] && c2[j-1] == c3[i+j-1]){
                    p[i][j] = p[i-1][j] || p[i][j-1];
                }else if (c1[i-1] == c3[i+j-1]){
                    p[i][j] = p[i-1][j];
                }else if (c2[j-1] == c3[i+j-1]){
                    p[i][j] = p[i][j-1];
                }
            }
        }
        return p[s1.length()][s2.length()];
    }
}
