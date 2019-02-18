package solution41_60;

/**
 * @Author: yhj
 * @Description: 这题必须多看看
 * @Date: Created in 2019-02-11.
 * @Modified By:
 */
public class PowxN {
    public double myPow(double x, int n) {
        if(n == 0){
            return 1;
        }
        long len = Math.abs((long)n);
        double result = 1;
        while (len != 0){
            // 判断是否除2余1,余1的话就多乘一个x
            if((len&1) == 1)
                result *= x;
            x = x*x;
            len = len >> 1;
        }
        return n<0?1.0/result:result;
    }
}
