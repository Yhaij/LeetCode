package solution21_40;

/**
 * Created by yhj on 2017/10/25.
 */
public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int next[] = clacuateNext(needle);
        int k = -1;
        for(int i = 0;i<haystack.length();i++){
            while (k > -1 && needle.charAt(k+1) != haystack.charAt(i)){
                k = next[k];
            }
            if(needle.charAt(k+1) == haystack.charAt(i)){
                k++;
            }
            if(k == needle.length()-1){
                return i-needle.length()+1;
            }
        }
        return -1;
    }

    public int[] clacuateNext(String pattern){
        int k = -1;
        int next[] = new int[pattern.length()];
        next[0] = -1;
        for(int i = 0;i<pattern.length();i++){
            while (k > -1 && pattern.charAt(k+1) != pattern.charAt(i)){
                k = next[k];
            }
            if(pattern.charAt(k+1) == pattern.charAt(i)){
                k++;
            }
            next[i] = k;
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(new ImplementStrStr().strStr("miss", "a"));
    }
}
