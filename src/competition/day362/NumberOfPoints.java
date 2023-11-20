package competition.day362;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-10 10:30
 */
public class NumberOfPoints {
    public static void main(String[] args) {
        List<List<Integer>> nums  = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        tmp.add(3);tmp.add(6);
        nums.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(1);tmp.add(5);
        nums.add(tmp);
        tmp = new ArrayList<>();
        tmp.add(4);tmp.add(7);
        nums.add(tmp);
        System.out.println(numberOfPoints(nums));
    }
    public static int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums,(a,b)->a.get(0)-b.get(0));
        int ans = 0;
        int l = nums.get(0).get(0),r = nums.get(0).get(1);
        for(int i = 1;i < nums.size();i++){
            if(r < nums.get(i).get(0)){
                ans += r - l +1;
                l = nums.get(i).get(0);
                r = nums.get(i).get(1);
            }else {
                r = Math.max(r,nums.get(i).get(1));
            }
        }
        ans += r - l +1;
        return ans;
    }
}
