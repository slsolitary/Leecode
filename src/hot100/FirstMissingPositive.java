package hot100;

import java.util.HashSet;

/**
 * @author heyao
 * @date 2023-08-02 9:47
 * 40.缺失的第一个正数
 */
public class FirstMissingPositive {
    public static void main(String[] args) {
        FirstMissingPositive test = new FirstMissingPositive();
        int[] nums = {1,1000};
        System.out.println(test.firstMissingPositive(nums));
    }
    public int firstMissingPositive(int[] nums) {
        //对于长度为n的数组，答案一定为[1,N+1]
//        int n = nums.length;
//        HashSet<Integer> set = new HashSet<>();
//        for(int num : nums){
//            set.add(num);
//        }
//
//        for(int i = 1;i <= n;i++){
//            if(!set.contains(i)){
//                return i;
//            }
//        }
//
//        return n+1;

        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] > 0 && nums[i] <= n && nums[nums[i]-1] != nums[i]){
                swap(nums,nums[i]-1,i);
            }
        }

        for(int i = 0;i < n;i++){
            if(nums[i] != i+1){
                return i;
            }
        }

        return n+1;
    }

    public void swap(int[] nums,int l,int r){
        int tmp = nums[l];
        nums[l] = nums[r];
        nums[r] = tmp;
    }
}
