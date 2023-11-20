package work.mtd0526;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-26 10:56
 */
public class Five {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//长度
        int k = input.nextInt();//平均数
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = input.nextInt();
        }
        long ans = find(nums, n, k);
        System.out.println(ans);
//        long[] nums = new long[n];
//        for(int i = 0;i < n;i++){
//            nums[i] = input.nextLong();
//        }
        int left = 0,right = 0;
        long res = -1;
        long sum = 0;
        while (left <= right){
            if(right < n){
                sum += nums[right];
            }
            long tmp = (right-left+1);
//            double mean = sum / tmp;
//            if(mean == k && res < tmp){
//                res = tmp;
//            }else if(mean > k){
//                sum -= nums[left];
//                left++;
//            }
            if(tmp*k == sum && res < tmp){
                res = tmp;
            }else if(tmp*k < sum){
                sum -= nums[left];
                left++;
            }
            if(right < n){
                right++;
            }else
                break;
        }
        System.out.println(res);
    }

    static long find(int[] nums,int n,int k){
        int sum = 0;
        long ans = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        map.put(0,new ArrayList<>());
        map.get(0).add(0);
        for(int i = 1;i <= n;i++){
            sum += nums[i-1];
            int key = sum - i * k;
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(i);
            int size = map.get(key).size();
            ans = Math.max(ans,map.get(key).get(size-1)-map.get(key).get(0));
        }
        return ans != 0 ? ans : -1;
    }
}
