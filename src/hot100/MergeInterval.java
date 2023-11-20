package hot100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author heyao
 * @date 2023-08-01 21:31
 */
public class MergeInterval {
    public static void main(String[] args) {
        MergeInterval test = new MergeInterval();
        int[][] num = {{1,3},{2,6},{8,10}};
        int[][] merge = test.merge(num);
        System.out.println(merge.length);
    }
    public int[][] merge(int[][] intervals) {
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int n = intervals.length;
        int l = intervals[0][0], r = intervals[0][1];
        for(int i = 1;i < n;i++){
            if(r < intervals[i][0]){
                list.add(new int[]{l,r});
                l = intervals[i][0];
                r = intervals[i][1];
            }else {
                r = Math.max(r,intervals[i][1]);
            }
        }
        list.add(new int[]{l,r});
        return list.toArray(new int[][]{});
    }
}
