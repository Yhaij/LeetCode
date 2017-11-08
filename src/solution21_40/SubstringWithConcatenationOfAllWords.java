package solution21_40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yhj on 2017/10/27.
 */
public class SubstringWithConcatenationOfAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = words.length, l = s.length();
        List<Integer> result = new ArrayList<>();
        if(n <=0){
            return result;
        }
        int k = words[0].length();
        Map<String, Integer> map = new HashMap<>(n);
        for(int i = 0;i<n;i++){
            Integer index = map.get(words[i]);
            if(index == null){
                map.put(words[i], 0);
            }else {
                map.put(words[i], index+1);
            }
        }
        int last = l-k+1;
        for(int i = 0;i<k;i++){
            int left = i, count = 0;
            Map<String, Integer> matchMap = new HashMap<>(n);
            for(int j = i;j<last;j += k){
                String sub = s.substring(j, j+k);
                if(map.containsKey(sub)){
                    Integer index = matchMap.get(sub);
                    if(index == null){
                        index = 0;
                        matchMap.put(sub, index);
                    }else {
                        matchMap.put(sub, ++index);
                    }
                    if(index <= map.get(sub)){
                        count++;
                    }else {
                        while (matchMap.get(sub) > map.get(sub)){
                            String sub1 = s.substring(left, left+k);
                            Integer value = matchMap.get(sub1)-1;
                            if(value < map.get(sub1)){
                                count--;
                            }
                            matchMap.put(sub1, value);
                            left += k;
                        }
                    }
                    if(count == n){
                        result.add(j-n*k+k);
                        String sub1 = s.substring(left, left+k);
                        matchMap.put(sub1, matchMap.get(sub1)-1);
                        count--;
                        left += k;
                    }
                }else {
                    matchMap.clear();
                    count = 0;
                    left = j+k;
                }
            }
        }
        return result;
    }
}
