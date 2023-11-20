package competition.day358;

import java.util.*;

/**
 * @author heyao
 * @date 2023-08-13 10:31
 */
public class MaxSum {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        MaxSum test = new MaxSum();
        System.out.println(test.maxSum(nums));
    }
    public int maxSum(int[] nums) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++){
            //单个数最大数位
            int a = maxNum(nums[i]);
            List<Integer> list = map.getOrDefault(a, new ArrayList<>());
            list.add(nums[i]);
            map.put(a,list);
        }
        int res = -1;
        for (List<Integer> list : map.values()){
            if(list.size() == 1){
                continue;
            }
            Collections.sort(list);
            int n = list.size();
            res = Math.max(list.get(n-1)+list.get(n-2),res);
        }
        return res;
    }

    public int maxNum(int num){
        int res = 0;
        while (num != 0){
            res = Math.max(res,num % 10);
            num /= 10;
        }
        return res;
    }
}
