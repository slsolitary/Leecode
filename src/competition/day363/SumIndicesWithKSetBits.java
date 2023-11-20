package competition.day363;

import java.util.List;

/**
 * @author heyao
 * @date 2023-09-17 10:30
 */
public class SumIndicesWithKSetBits {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for(int i = 0;i < nums.size();i++){
            if(countOne(i) == k){
                ans += nums.get(i);
            }
        }
        return ans;
    }

    public int countOne(int num){
        int ans = 0;
        while (num > 0){
            if((num & 1) == 1){
                ans++;
            }
            num = num >> 1;
        }
        return ans;
    }
}
