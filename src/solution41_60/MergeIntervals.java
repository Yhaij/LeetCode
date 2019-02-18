package solution41_60;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: yhj
 * @Description:
 * 首先将starts和end分别从大到小排序
 * 情况1，当starts[i+1] > end[i]时，则无论怎样starts[i+1]个都不会和之前的区间发生交集，即下面这三个是不会发生交集的
 * starts: ●    ●       ●
 * ends:    ●      ●     ●
 * 情况2，当starts[i+1] <= end[i]时,当连续的这种情况发生，这其中无论shatr和end怎么组合，这几个区间都是相交的，比如下面的前三者start和end
 * starts: ●    ●       ●           ●
 * ends:            ●      ●     ●     ●
 * 因此在出现情况一的时候说明区间开始不相交，我们只需要记录两个不相交（情况一）的之间的star和end即可
 **/
public class MergeIntervals {
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

    public List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() == 0){
            return intervals;
        }
        int[] starts = new int[intervals.size()];
        int[] ends = new int[intervals.size()];
        int i = 0;
        for(Interval each: intervals){
            starts[i] = each.start;
            ends[i++] = each.end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> result = new ArrayList<>();
        int j = 0;
        for(i = 0;i < intervals.size()-1; i++){
            if(starts[i+1] > ends[i]){
                result.add(new Interval(starts[j], ends[i]));
                j = i+1;
            }
        }
        result.add(new Interval(starts[j], ends[i]));
        return result;
    }


//    public List<Interval> merge(List<Interval> intervals) {
//        if(intervals == null || intervals.size() == 0){
//            return intervals;
//        }
//        intervals.sort(new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                if(o1.start > o2.start){
//                    return 1;
//                }else if(o1.start < o2.start){
//                    return -1;
//                }else
//                    return 0;
//            }
//        });
//        int start = intervals.get(0).start, end = intervals.get(0).end;
//        List<Interval> result = new ArrayList<>();
//        for(Interval each: intervals){
//            if(each.start >= start && each.start <= end){
//                end = Math.max(end, each.end);
//            }else {
//                result.add(new Interval(start, end));
//                start = each.start;
//                end = each.end;
//            }
//        }
//        result.add(new Interval(start, end));
//        return result;
//    }


}
