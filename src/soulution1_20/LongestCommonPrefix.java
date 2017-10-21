package soulution1_20;

/**
 * Created by yhj on 2017/10/10.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        StringBuilder preCommonStr = new StringBuilder();
        int minLen = strs[0].length();
        for(int i = 0;i < strs.length; i++){
            if(strs[i].length() < minLen){
                minLen = strs[i].length();
            }
        }
        for(int i = 0;i < minLen;i++){
            for(int j = 0;j < strs.length ; j++){
                if(strs[0].charAt(i) != strs[j].charAt(i)){
                    return preCommonStr.toString();
                }
            }
            preCommonStr.append(strs[0].charAt(i));
        }
        return preCommonStr.toString();
    }
}
