package solution81_100;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 22:53 2019/3/12
 * @Modified By:
 **/
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)){
            return true;
        }
        int[] count = new int[26];
        // 首先判断是不是包含相同个数的字母
        for(int i = 0;i < s1.length();i++){
            count[s1.charAt(i) - 'a'] ++;
            count[s2.charAt(i) - 'a'] --;
        }
        for(int item: count){
            if(item != 0){
                return false;
            }
        }
        // 递归判断
        for(int i = 0; i < s1.length()-1;i++){
            String p = s1.substring(0, i+1);
            String q = s1.substring(i+1);
            if ((isScramble(p, s2.substring(0, i+1)) && isScramble(q, s2.substring(i+1))) ||
                    (isScramble(q, s2.substring(0, q.length())) && isScramble(p, s2.substring(q.length())))){
                return true;
            }
        }
        return false;
    }
}
