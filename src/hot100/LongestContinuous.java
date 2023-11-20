package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class LongestContinuous {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for(int i = 0;i < n;i++){
            nums[i] = scanner.nextInt();
        }
        LongestContinuous test = new LongestContinuous();
        System.out.println(test.longestConsecutive(nums));
    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        for(int num : nums){
            set.add(num);
        }
        int ans = 0;
        int current = 0;
        for(int num : nums){
            if(!set.contains(num-1)){
                current = 0;
                while (set.contains(num)){
                    current++;
                    num++;
                }
                ans = Math.max(current,ans);
            }
        }
        return ans;
    }
}
