package solution61_80;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 22:58 2019/2/22
 * @Modified By:
 **/
public class Sqrtx {
//    public int mySqrt(int x) {
//        for(int i =1;i <= 46340;i++){
//            int n = i*i;
//            if(n > x){
//                return i-1;
//            }
//            if(n == x){
//                return i;
//            }
//        }
//        return 0;
//    }
    public int mySqrt(int x) {
        long t = x;
        t = 0x5f3759df - (t >> 1);
        while (!(t*t <= x && (t+1)*(t+1) > x))
            t = (x/t + t)/2;
        return (int)t;
    }
}
