package leetcode;

import java.util.*;

public class Insert_Interval_Array_P57{
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int start = newInterval[0];
            int end = newInterval[1];

            List<int[]> left = new ArrayList<>();
            List<int[]> right = new ArrayList<>();

            for(int[] interval: intervals){
                int first = interval[0];
                int last = interval[1];

                if      (last<start) left.add(interval);
                else if (first>end)  right.add(interval);
                else {
                    start = Math.min(first, start);
                    end   = Math.max(last, end);
                }
            }
            List<int[]> result = new ArrayList<>(left);
            result.add(new int[]{start,end});
            result.addAll(right);
            return result.toArray(new int[result.size()][]);
        }
}
