package solution61_80;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yhj
 * @Description: char的范围在0到126所以用127长度的数组表示，每个代表该char的个数，l、r滑动窗口来代表其在该窗口是否符合个数
 * @Date: Created in 2019/2/26.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.equals("")){
            return "";
        }
        int[] tArr = new int[256];
        for (int i = 0; i < t.length();i++){
            tArr[t.charAt(i)] ++;
        }
        int[] sArr = new int[256];
        int l = 0, r = 0, count = 0;
        int startIndex = -1, minLength = s.length()+1;
        while (l < s.length()){
            if(r < s.length() && count < t.length()){
                char c = s.charAt(r);
                if(sArr[c] < tArr[c]){
                    count ++;
                }
                sArr[c] ++;r++;
            }else {
                if(count == t.length() && r - l < minLength){
                    startIndex = l;
                    minLength = r-l;
                }
                char c = s.charAt(l);
                sArr[c] --;
                if(sArr[c] < tArr[c]){
                    count --;
                }
                l++;
            }
        }
        if(startIndex != -1){
            return s.substring(startIndex, startIndex + minLength);
        }
        return "";
    }
}
