package solution61_80;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/21.
 */
public class AddBinary {
    public String addBinary(String a, String b) {
        if(a.length() < b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        char[] result = new char[a.length()];
        int flag = 0;
        int i = 1;
        for(; i <= b.length();i++){
            if(a.charAt(a.length()-i) == '1' && b.charAt(b.length()-1) == '1'){
                result[a.length()-i] =  (char) ('0' + flag);
                flag = 1;
            }else if(a.charAt(a.length()-i) == '0' && b.charAt(b.length()-1) == '0'){
                result[a.length()-i] =  (char) ('0' + flag);
                flag = 0;
            }else {
                if(flag == 1){
                    result[a.length()-i] = '0';
                }else {
                    result[a.length()-i] = '1';
                }
            }
        }
        while (i <= a.length()){
            if(a.charAt(a.length()-i) == '1' && flag == 1){
                result[a.length()-i] = '0';
            }else {
                result[a.length()-i] = (char) (a.charAt(a.length()-i) + flag);
                flag = 0;
            }
            i++;
        }
        if(flag == 1){
            return "1" + new String(result);
        }
        return new String(result);
    }
}
