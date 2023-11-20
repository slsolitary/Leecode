package competition.day368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author heyao
 * @date 2023-10-22 10:46
 */
public class MinGroupsForValidAssignment {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,3,3,1,1,2,2,3,1,3,2};
        int[] nums = new int[]{10,10,10,3,1,1};
        System.out.println(minGroupsForValidAssignment(nums));
    }
    public static int minGroupsForValidAssignmentII(int[] nums) {
        //统计数字出现频次
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //记录频次数组的最小值
        ArrayList<Integer> list = new ArrayList<>();
        int mi = 1000005;
        for (int key : map.keySet()) {
            mi = Math.min(mi,map.get(key));
            list.add(map.get(key));
        }
        int ans = 100005;
        int res = 0;
        //假设存在一个数x，它可以被拆成a个y和b个y+1
        //遍历y的值∈[1,mi],统计频次数组可以被拆分的数目，最小即为所求
        while (mi > 0){
            res = 0;
            boolean flag = true;
            for(int i : list){
                if(i < mi){
                    flag = false;
                    break;
                }
                int x = i / (mi+1);//将当前值拆为x个(mi+1)和1个y
                int y = i - x*(mi+1);
                while (x >= 0 && y % mi != 0){//将当前值拆为x个(mi+1)和y/mi个mi
                    x--;
                    y = i - x*(mi+1);
                }
                if(x == -1){
                    flag=false;
                    break;
                }
                res = res + x + y/mi;
            }
            if(flag == true){
                ans = Math.min(ans,res);
            }
            mi--;
        }
        return ans;
    }
    public static int minGroupsForValidAssignment(int[] nums) {
        //统计数字出现频次
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        n = map.size();
        int[] arr = new int[n];
        int i = 0;
        HashMap<Integer, Integer> fre = new HashMap<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            arr[i++] = entry.getValue();
            fre.put(entry.getValue(),map.getOrDefault(entry.getKey(),0)+1);
        }
        Arrays.sort(arr);
        //频次数组的最大值与最小值之差不超过1的最小分组数
        if(n == 1 || arr[n-1]-arr[0] <= 1){
            return n;
        }
        int minV = arr[0];
        int res = n;
        for(i = n-1;i > 0;i--){
            if(arr[i]-minV <= 1){
                continue;
            }
            int x = arr[i] / minV;
            int y = arr[i] % minV;
            int z = arr[i]-minV;
            map.put(minV,map.get(minV)+x);
            if(arr[i] % minV != 0){
                arr[i]=y;
                x ++;
                minV =  y;
            }else {
                arr[i]=minV;
            }
            res += x-1;
        }
        return res;
    }
}
