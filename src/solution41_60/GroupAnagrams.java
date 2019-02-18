package solution41_60;

import java.util.*;

/**
 *
 *
 * @Author: yhj
 * @Description:
 * @Date: Created in 2019-02-11.
 * @Modified By:
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String str: strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            if(map.containsKey(sortStr)){
                map.get(sortStr).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sortStr, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}
