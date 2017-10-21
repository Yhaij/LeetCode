package soulution1_20;

/**
 * Created by yhj on 2017/9/27.
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        if(str.length() == 0)
            return 0;
        int index = 0,sign = 1;
        for(;index < str.length() && str.charAt(index) == ' '; index++ );
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+'?1:-1;
            index ++;
        }
        int total = 0;
        for(;index<str.length();index++){
            if(str.charAt(index) <'0' || str.charAt(index) > '9'){
                break;
            }else {
                int x = str.charAt(index) - '0';
                if (Integer.MAX_VALUE / 10 < total || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < x) {
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                total = total*10 + x;
            }
        }
        return total*sign;
    }
}
