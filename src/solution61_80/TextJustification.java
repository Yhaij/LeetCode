package solution61_80;

import java.util.ArrayList;
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
        List<String> result = new ArrayList<>();
        for(int i = 0;i < words.length;i++){
            //单词中间插入一个空格的总数是否大于maxWidth
            if(charCount + words[i].length() + i - p> maxWidth){
                StringBuilder sb = new StringBuilder();
                int d = i - p;
                if(d == 1){
                    sb.append(words[p]);
                    for(int j = maxWidth - charCount;j > 0;j--){
                        sb.append(" ");
                    }
                }else {
                    //计算单词之间最少空格数
                    int spaceNum = (maxWidth - charCount)/(d-1);
                    //余数作为多插入一个的空隙数
                    int ys = (maxWidth - charCount)%(d-1);
                    // 插入的空格位数
                    StringBuilder tmp = new StringBuilder();
                    for(int j = 0;j < spaceNum;j++){
                        tmp.append(" ");
                    }
                    String spaces = tmp.toString();

                    for (int j = 0;j < d-1;j++){
                        sb.append(words[p+j]);
                        sb.append(spaces);
                        if(j < ys){
                            sb.append(" ");
                        }
                    }
                    sb.append(words[p+d-1]);
                }
                result.add(sb.toString());
                p = i;
                charCount = words[i].length();
            }else {
                charCount += words[i].length();
            }
        }

        //最后插入所有剩余单词
        StringBuilder sb = new StringBuilder();
        for(int i = p;i < words.length-1;i++){
            sb.append(words[i]);
            sb.append(" ");
            maxWidth -= (words[i].length() + 1);
        }
        sb.append(words[words.length-1]);
        maxWidth -= words[words.length-1].length();
        for(int i = 0; i < maxWidth;i++){
            sb.append(" ");
        }
        result.add(sb.toString());
        return result;
    }
}
