package competition.day359;

import java.util.HashMap;
import java.util.List;

/**
 * @author heyao
 * @date 2023-08-20 11:33
 */
public class LongestEqualSubarray {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int left = 0,right = 0;
        int maxFreq = 0,maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(right = 0;right < nums.size();right++){
            int num = nums.get(right);
            map.put(num,map.getOrDefault(num,0)+1);
            maxFreq = Math.max(maxFreq,map.get(num));
            //当窗口内的数组个数-出现的最大频次=其他应该删除的元素个数>k时，更新窗口左侧范围
            while (right-left+1-maxFreq > k){
                map.put(nums.get(left),map.get(nums.get(left))-1);
                left++;
            }
            maxLength = Math.max(maxLength,maxFreq);
        }
        return maxLength;
    }
}
