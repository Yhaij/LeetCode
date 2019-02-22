package solution61_80;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 23:07 2019/2/22
 * @Modified By:
 **/
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int pp = 1;
        int p = 2;
        for(int i = 3; i <= n;i++){
            int tmp = p;
            p += pp;
            pp = tmp;
        }
        return p;
    }
}
