package soulution1_20;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhj on 2017/10/13.
 */
public class LetterCombinationsOfAPhoneNumber {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        for(int i = 0;i<digits.length();i++){
            if(digits.charAt(i) == '9'){
                if(list.size() == 0){
                    list.add("w");
                    list.add("x");
                    list.add("y");
                    list.add("z");
                }else {
                    for(int j = 0,k = list.size();j<k;j++){
                        list.add(list.get(j)+"x");
                        list.add(list.get(j)+"y");
                        list.add(list.get(j)+"z");
                        list.set(j, list.get(j)+"w");
                    }
                }
            }else if(digits.charAt(i) == '7'){
                if(list.size() == 0){
                    list.add("p");
                    list.add("q");
                    list.add("r");
                    list.add("s");
                }else {
                    for(int j = 0,k = list.size();j<k;j++){
                        list.add(list.get(j)+"q");
                        list.add(list.get(j)+"r");
                        list.add(list.get(j)+"s");
                        list.set(j, list.get(j)+"p");
                    }
                }
            }else {
                int diff  = digits.charAt(i) - '2';
                int flag = 0;
                if(diff == 6){
                    flag ++;
                }
                if(list.size() == 0){
                    list.add(String.valueOf((char)('a'+3*diff+flag)));
                    list.add(String.valueOf((char)('a'+3*diff+1+flag)));
                    list.add(String.valueOf((char)('a'+3*diff+2+flag)));
                }else {
                    for(int j = 0, k = list.size();j<k;j++){
                        list.add(list.get(j)+String.valueOf((char)('a'+3*diff+1+flag)));
                        list.add(list.get(j)+String.valueOf((char)('a'+3*diff+2+flag)));
                        list.set(j, list.get(j)+String.valueOf((char)('a'+3*diff+flag)));
                    }
                }
            }
        }
        return list;
    }

}
