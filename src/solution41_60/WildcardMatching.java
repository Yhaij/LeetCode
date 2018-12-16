package solution41_60;

/**
 * @Author: yhj
 * @Description: 利用动态规划求解，当遇到*时，取(i-1,j),(i,j-1),(i-1,j-1)的或，
 *               遇到?时,取(i-1,j-1)的值，其余需要对比，相同则取(i-1,j-1)的值，否则false
 * @Date: Created in 22:38 2018/12/15
 * @Modified By:
 **/
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean[][] value = new boolean[p.length()+1][s.length()+1];
        value[0][0] = true;
        for(int i = 1;i <= s.length();i++){
            value[0][i] = false;
        }
        for(int i = 1;i <= p.length(); i++){
            if(p.charAt(i-1) == '*'){
                value[i][0] = value[i-1][0];
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = (value[i][j-1] || value[i-1][j] || value[i-1][j-1]);
                }
            }else if(p.charAt(i-1) == '?'){
                value[i][0] = false;
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = value[i-1][j-1];
                }
            }else {
                value[i][0] = false;
                for(int j = 1;j <= s.length(); j++){
                    value[i][j] = s.charAt(j-1) == p.charAt(i-1) && value[i-1][j-1];
                }
            }

        }
        return value[p.length()][s.length()];

    }

    public static void main(String[] args) {
        System.out.println(new WildcardMatching().isMatch("aa", "*"));
    }
}
