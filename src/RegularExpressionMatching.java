import java.util.HashMap;

/**
 * Created by yhj on 2017/9/30.
 */
public class RegularExpressionMatching {
//    public boolean isMatch(String s, String p) {
//        if(p.length() == 0){
//            return s.length() == 0?true:false;
//        }
//        int i = 0, j = 0;
//        char pre = p.charAt(j);
//        while(i < s.length() && j < p.length()){
//            if(compareChar(s.charAt(i),p.charAt(j))){
//                pre = p.charAt(j);
//                i++;
//                j++;
//            }else {
//                if(p.charAt(j) == '*'){
//                    if(compareChar(s.charAt(i),pre)){
//                        i++;
//                    }else {
//                        pre = p.charAt(j);
//                        j++;
//                    }
//                }else {
//                    if(j < p.length()-1 && p.charAt(j+1) != '*'){
//                        return false;
//                    }else {
//                        pre = p.charAt(j);
//                        j++;
//                    }
//                }
//            }
//        }
//        if(i == s.length() && (j == p.length() || (j >= p.length() - 2 && p.charAt(p.length()-1) == '*'))){
//            return true;
//        }else {
//            return false;
//        }
//    }

    private enum Result{
        TRUE, FALSE
    }
    private Result[][] memo;

    /**
     * 递归解决方案
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
//        return compareStr(s, p);
        memo = new Result[s.length()+1][p.length()+1];//记录a从i起的子字符串是否等于b从j起的子字符串
        return compareStr(0, 0, s, p);
    }


    private boolean compareStr(String a, String b){
        if(b.length() == 0){//如果b空,递归结束
            return a.length() == 0?true:false;
        }
        if(a.length() > 0 && compareChar(a.charAt(0), b.charAt(0))){
            if(b.length() > 1 && b.charAt(1) == '*') {//b的下一个字符是*,递归判断*代表的个数
                return compareStr(a.substring(1), b) || compareStr(a, b.substring(2));
            }else {
                return compareStr(a.substring(1),b.substring(1));
            }
        }else {
            if(b.length() > 1 && b.charAt(1) == '*'){//a为空或者当前连个字符不匹配，若b的下一个是*,则直接跳过这两个在匹配
                return compareStr(a, b.substring(2));
            }else {
                return false;
            }
        }
    }

    /**
     * 相比与纯迭代的方法，增加了子字符串比较的缓存结果，以空间换时间，减少迭代深度
     * @param i
     * @param j
     * @param a
     * @param b
     * @return
     */
    private boolean compareStr(int i, int j, String a, String b){
        if(memo[i][j] != null){
            return memo[i][j] == Result.TRUE;
        }
        if(j == b.length()){
            return i == a.length();
        }
        boolean ans;
        if(i < a.length() && compareChar(a.charAt(i), b.charAt(j))){
            if(j < b.length()-1 && b.charAt(j+1) == '*'){
                ans = compareStr(i+1, j, a, b) || compareStr(i, j+2, a, b);
            }else {
                ans = compareStr(i+1 , j+1, a, b);
            }
        }else {
            if(j < b.length()-1 && b.charAt(j+1) == '*'){
                ans = compareStr(i, j+2, a, b);
            }else {
                ans = false;
            }
        }
        memo[i][j] = ans? Result.TRUE:Result.FALSE;
        return ans;
    }

    /**
     * 判断两个字符是否相等
     * @param a
     * @param b
     * @return
     */
    private boolean compareChar(char a, char b){
        if(a == b || b == '.'){
            return true;
        }else{
            return false;
        }
    }

}
