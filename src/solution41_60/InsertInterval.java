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
            }else {
                break;
            }
            i++;
        }


        while (i < intervals.size()){
            Interval each = intervals.get(i);
            if(each.start > newInterval.end){
                break;
            }else {
                if(each.start < newInterval.start){
                    newInterval.start = each.start;
                }
                if(each.end > newInterval.end){
                    newInterval.end = each.end;
                }
            }
            i++;
        }
        result.add(newInterval);
        while (i < intervals.size()){
            result.add(intervals.get(i));
            i++;
        }
        return result;
    }


//    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
//        List<Interval> result = new ArrayList<>();
//        int i = 0;
//        while (i < intervals.size()){
//            Interval each = intervals.get(i);
//            if(each.end < newInterval.start){
//                result.add(each);
//            }else {
//                break;
//            }
//            i++;
//        }
//
//
//        while (i < intervals.size()){
//            Interval each = intervals.get(i);
//            if(each.start > newInterval.end){
//                break;
//            }else {
//                if(each.start < newInterval.start){
//                    newInterval.start = each.start;
//                }
//                if(each.end > newInterval.end){
//                    newInterval.end = each.end;
//                }
//            }
//            i++;
//        }
//        result.add(newInterval);
//        while (i < intervals.size()){
//            result.add(intervals.get(i));
//            i++;
//        }
//        return result;
//    }
}
