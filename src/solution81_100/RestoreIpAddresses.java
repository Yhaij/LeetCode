package solution81_100;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/03/14.
 */
public class RestoreIpAddresses {
    public List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        char[] c = s.toCharArray();
        traceBack(c, 0, "", 0);
        return result;
    }

    public void traceBack(char[] c, int index, String s, int count){
        if(index >= c.length || count >= 4){
            if(index == c.length && count == 4){
                result.add(s.substring(0, s.length()-1));
            }
            return;
        }
        count ++;
        traceBack(c, index+1, s + c[index] + ".", count);
        if(c[index] != '0'){
            if(index < c.length-1){
                traceBack(c, index+2, s + c[index] + c[index+1] + ".", count);
            }
            if(index < c.length-2 && ((c[index] - '0')*100 + (c[index+1] - '0')*10 + c[index+2] - '0') <= 255){
                traceBack(c, index+3, s + c[index] + c[index+1] + c[index+2] + ".", count);
            }
        }
    }
}
