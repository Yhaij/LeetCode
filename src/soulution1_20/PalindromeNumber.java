package soulution1_20;

/**
 * Created by yhj on 2017/9/29.
 */
public class PalindromeNumber {
//    public boolean isPalindrome(int x) {
//        if(x < 0) {
//            return false;
//        }
//        int s = x,len = 1;
//        while(s >= 10 || s <= -10){
//            s = s/10;
//            len++;
//        }
//        for(int i = 0;i<len/2;i++){
//            int lastNum = x%(int)Math.pow(10,i+1)/(int)Math.pow(10,i);
//            int firsNum = x/(int)Math.pow(10,len-1-i)%10;
//            if(lastNum != firsNum)
//                return false;
//        }
//        return true;
//    }

    public static boolean isPalindrome(int x) {
        if(x < 0)
            return false;
        int p =x,q = 0;
        while(p >= 10){
            q = q*10 + p%10;
            p = p/10;
        }
        return (q*10 + p) == x?true:false;
    }
}
