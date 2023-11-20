package competition.day357;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heyao
 * @date 2023-08-06 10:40
 */
public class CanSplitArray {
    public static void main(String[] args) {
        CanSplitArray test = new CanSplitArray();
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(1);
        nums.add(2);
        System.out.println(test.canSplitArray(nums, 3));
    }
    //不管怎么拆分，最后一定会出现三个数需要拆成两个数+一个数的形式，要满足这个条件，这两个数之和必须大于等于m。
    //只要这个条件满足，n个数最后一定可以拆成这三个数，最后拆成符合条件的答案。
    public boolean canSplitArray(List<Integer> nums, int m) {
        int length = nums.size();
        if(length <= 2){
            return true;
        }
        for(int i =1;i < length;i++){
            if(nums.get(i)+nums.get(i-1) >= m)
                return true;
        }
        return false;
//        int length = nums.size();
//        if(length <= 2){
//            return true;
//        }
//        return backTracking(nums,m,0,length-2) || backTracking(nums,m,1,length-1);
    }

    //其中一个子数组为[left,right]
    public boolean backTracking(List<Integer> nums, int m,int left,int right){
        if(right-left < 2){
            return true;
        }
        int sum = 0;
        for(int i = left;i <= right;i++){
            sum += nums.get(i);
        }
        if(sum < m){
            return false;
        }
        return backTracking(nums,m,left+1,right) || backTracking(nums,m,left,right-1);
    }
}
