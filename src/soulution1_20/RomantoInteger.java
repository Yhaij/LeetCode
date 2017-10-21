package soulution1_20;

/**
 * Created by yhj on 2017/10/8.
 */
public class RomantoInteger {
    public int romanToInt(String s) {
        int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int p = 0;
        int result = 0;
        while (p<s.length()){
            for(int i = 0;i < strs.length; i++){
                if(s.indexOf(strs[i], p) == p){
                    result += values[i];
                    p += strs[i].length();
                    break;
                }
            }
        }
        return result;
    }
}
