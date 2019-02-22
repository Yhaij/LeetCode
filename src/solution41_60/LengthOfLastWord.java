package solution41_60;

/**
 * @Author: yhj
 * @Description:
<<<<<<< HEAD
 * @Date: Created in 20:00 2019/2/19
 * @Modified By:
 **/
=======
 * @Date: Created in 2019/2/19.
 */
>>>>>>> tmp
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int result = 0;
        int i = s.length()-1;
        for(;i >= 0; i--){
            if(s.charAt(i) != ' '){
                break;
            }
        }
        for(;i >= 0; i--){
            if(s.charAt(i) == ' '){
                break;
            }
            result++;
        }
        return result;
    }
}
