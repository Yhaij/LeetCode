package solution41_60;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * @Date: Created in 23:41 2019/2/18
 * @Modified By:
 **/
public class InsertInterval {
    class Interval {
        int start;
        int end;
        Interval() {
            start = 0;
            end = 0;
        }
        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        int i = 0;
        while (i < intervals.size()){
            Interval each = intervals.get(i);
            if(each.end < newInterval.start){
                result.add(each);
                i++;
            }else {
                newInterval.start = Math.min(each.start, newInterval.start);
                newInterval.end = Math.max(each.end, newInterval.end);
                break;
            }
        }
        while (i < intervals.size()-1){
            Interval each = intervals.get(i+1);
            if(each.start > newInterval.end){
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
                break;
            }
            i++;
        }
        i++;
        result.add(newInterval);
        while (i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }
}
