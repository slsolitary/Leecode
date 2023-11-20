package competition.day359;

import java.util.Collections;
import java.util.Deque;
import java.util.List;

/**
 * @author heyao
 * @date 2023-08-20 10:46
 */
public class MaximizeTheProfit {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        Collections.sort(offers,(a,b) -> a.get(1)-b.get(1));
        int left = 0,right = 0,value = 0;
        int ans = 0;
        //dp[i]：编号0-i的房子卖出去能够获得的最大利益
        int[] dp = new int[n+1];
        //客户索引，先满足end小的客户的需求
        int index = 0;
        for(int i = 1;i <= n;i++){
            //如果编号为i的房子没卖出去，那么最大利益就是编号0到（i-1）的房子卖出去的最大利益
            dp[i]=dp[i-1];
            while (index < offers.size() && offers.get(index).get(1) < i){
                dp[i] = Math.max(dp[i],dp[offers.get(index).get(0)]+offers.get(index).get(2));
            }
        }

        return dp[n];
    }
}
