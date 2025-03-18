package March;

import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals{

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int startIndex = 0;
        for(int i=1; i<intervals.length; i++){
            if(intervals[startIndex][1] >= intervals[i][0]){
                intervals[startIndex][1] = Math.max(intervals[startIndex][1], intervals[i][1]);
            }else{
                startIndex++;
                intervals[startIndex] = intervals[i];
            }
        }
        return Arrays.copyOfRange(intervals, 0, startIndex+1);
    }

    private void traverse(int[][] interval){
        for(int i=0;i<interval.length;i++){
            System.out.println(interval[i][0]+" "+interval[i][1]);
        }
        System.out.println("-------");
    }

    public static void main(String[] args) {
        int[][] intervals1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] expected1 = {{1, 6}, {8, 10}, {15, 18}};
        MergeIntervals mergeIntervals = new MergeIntervals();
        mergeIntervals.traverse(mergeIntervals.merge(intervals1));

        int[][] intervals2 = {{1, 4}, {4, 5}};
        int[][] expected2 = {{1, 5}};
        mergeIntervals.traverse(mergeIntervals.merge(intervals2));

        int[][] intervals3 = {{1, 4}, {0, 4}};
        int[][] expected3 = {{0, 4}};
        mergeIntervals.traverse(mergeIntervals.merge(intervals3));

        int[][] intervals4 = {{1, 4}, {0, 1}};
        int[][] expected4 = {{0, 4}};
        mergeIntervals.traverse(mergeIntervals.merge(intervals4));

        int[][] intervals5 = {{1, 4}, {2, 3}};
        int[][] expected5 = {{1, 4}};
        mergeIntervals.traverse(mergeIntervals.merge(intervals5));
    }

}