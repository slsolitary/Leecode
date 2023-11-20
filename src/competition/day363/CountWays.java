package competition.day363;

import javax.print.attribute.standard.NumberUp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-17 10:36
 */
public class CountWays {
    public static void main(String[] args) {
        CountWays test = new CountWays();
        List<Integer> nums = new ArrayList<>();
        nums.add(6);
        nums.add(0);
        nums.add(3);
        nums.add(3);
        nums.add(6);
        nums.add(7);
        nums.add(2);
        nums.add(7);
        System.out.println(test.countWays(nums));
    }
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int count = 0;
        int n = nums.size();
        if(nums.get(0) > 0){
            count++;
        }
        if(n > nums.get(n-1)){
            count++;
        }
        int left = 0;
        while(left < n-1){
            int len = left+1;
            if(len < nums.get(left+1) && len > nums.get(left)){
                count++;
            }
            left++;
        }
        return count;
    }
}
