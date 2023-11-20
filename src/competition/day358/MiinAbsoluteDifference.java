package competition.day358;

import java.util.List;
import java.util.TreeSet;

/**
 * @author heyao
 * @date 2023-08-13 11:12
 */
public class MiinAbsoluteDifference {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        int n = nums.size();
        int res = Integer.MAX_VALUE;

        TreeSet<Integer> set = new TreeSet<>();
        for(int i = x;i < n;i++){
            set.add((int) nums.get(i-x));
            int k = nums.get(i);

            Integer ceiling = set.ceiling(k);
            if(ceiling != null){
                res = Math.min(res,Math.abs(k-ceiling));
            }

            Integer floor = set.floor(k);
            if(floor != null){
                res = Math.min(res,Math.abs(k-floor));
            }
        }
        return res;
    }
}
