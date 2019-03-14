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
        for(int i = 1; i < )
    }
}
