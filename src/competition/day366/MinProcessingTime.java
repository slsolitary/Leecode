package competition.day366;

import java.util.Collections;
import java.util.List;

/**
 * @author heyao
 * @date 2023-10-08 10:32
 */
public class MinProcessingTime {
    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(tasks);
        int n = tasks.size();
        int[] dp = new int[n];
        for(int i = 0;i < n;i++){
            dp[i / 4] = Math.max(dp[i / 4],tasks.get(i));
        }
        int res = 0;
        Collections.sort(processorTime);
        int size = processorTime.size();
        for(int i = 0;i < size;i++){
            res = Math.max(res,processorTime.get(i)+dp[size-i-1]);
        }
        return res;
    }
}
