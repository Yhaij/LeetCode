package solution61_80;

import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019/2/21.
 */
public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int charCount = 0;
        int p = 0;
        for(int i = 0;i < words.length;i++){
            if(charCount + words[i].length() > maxWidth){
                p = i;
            }else {
                charCount += words[i].length();
            }
        }
    }
}
