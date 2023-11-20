package competition.day366;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author heyao
 * @date 2023-10-08 10:43
 */
public class MaxSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);list.add(6);list.add(5);list.add(8);
        MaxSum test = new MaxSum();
        System.out.println(test.maxSum(list, 2));
    }
    //对于同一个比特位，AND和OR不会改变都为0和都为1的情况，所以操作等价于
    //把一个数的0和另一个数的同一个比特位上的1交换
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1000000007;
        //cnt[i]：第i个比特位为1的数字个数
        int[] cnt = new int[30];
        for(int x : nums){
            for(int i = 0;i < 30;i++){
                cnt[i] += (x >> i) & 1;
            }
        }
        long ans = 0;
        while (k > 0){
            int x = 0;
            for(int i = 0;i < 30;i++){
                if(cnt[i] > 0){
                    cnt[i]--;
                    x |= 1 << i;
                }
            }
            ans = (ans + (long) x*x) % MOD;
            k--;
        }
        return (int) ans;
//        int[] arr = nums.stream().mapToInt(i -> i).toArray();
//        Arrays.sort(arr);
//        int mod = (int) (1e9 + 7);
//        int n = nums.size();
//        int left = 0,right = n-1;
//        int mid = n-k;
//        while (left < mid && right >= mid){
//            int x = arr[left] | arr[right];
//            int y = arr[left] & arr[right];
//            if(x > arr[right]){
//                arr[right] = x;
//                arr[left] = y;
//                left++;
//            }else if(x == arr[right]){
//                right --;
//            }
//        }
//        int res = 0;
//        for(int i = n-k;i < n;i++){
//            res = arr[i] * arr[i]% mod+res % mod;
//            res %= mod;
//        }
//        return res;
    }
}
