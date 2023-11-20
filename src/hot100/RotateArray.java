package hot100;

import java.util.Arrays;

/**
 * @author heyao
 * @date 2023-08-01 22:05
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        reverse(nums,0,n-1);
        reverse(nums,0,k-1);
        reverse(nums,k,n-1);
//        if(k == 0)
//            return;
//        int[] tmp = new int[n];
//        tmp = Arrays.copyOf(nums,n);
//        for(int i = 0;i < k;i++){
//            nums[i] = tmp[n-k+i];
//        }
//        for(int i = k;i < n;i++){
//            nums[i] = tmp[i-k];
//        }
        return;
    }

    public void reverse(int[] nums,int l,int r){
        while (l < r){
            int tmp = nums[l];
            nums[l++] = nums[r];
            nums[r++] = tmp;
        }
    }
}
