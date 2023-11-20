package work;

/**
 * @author heyao
 * @date 2023-10-09 15:25
 */
public class Solution {
    public int maximizeDonations (int[] donations) {
        int n = donations.length;
        if(n == 0){
            return 0;
        }
        if(n == 1){
            return donations[0];
        }
        return Math.max(fun(donations,0,n-1),fun(donations,1,n));
    }

    public int fun(int[] nums,int st,int en){
        int pre = 0, cur = 0;
        for(int i = st;i < en;i++){
            int tmp = cur;
            cur = Math.max(pre+nums[i],cur);
            pre = tmp;
        }
        return cur;
    }

    public boolean CheckGameResource (int[] sequence) {
        int n = sequence.length;
        //收集资源 1
        //消耗资源 0
        //当遇到1，count++；当遇到0，count--
        int count = 0;
        for(int i = 0;i < n;i++){
            if(sequence[i] == 1){
                count++;
            }else {
                count--;
            }
            if(count < 0){
                return false;
            }
        }
        return count == 0;
    }
}
