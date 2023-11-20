package competition.day356;

import java.util.HashMap;
import java.util.HashSet;

/**
 * @author heyao
 * @date 2023-07-30 10:37
 */
public class countCompleteSubarray {
    public static void main(String[] args) {
        countCompleteSubarray test = new countCompleteSubarray();
        int[] nums = new int[]{5,5,5,5};
        System.out.println(test.countCompleteSubarrays(nums));
    }


    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < n;i++){
            if(!set.contains(nums[i])){
                set.add(nums[i]);
            }
        }
        int res = 0;
        int m = set.size();

        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0,right = 0;
        while (right < n){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while (left <= right && map.size() == m){
                res += (n-right);
                map.put(nums[left],map.get(nums[left])-1);
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            right++;

        }
        return res;
    }
}
