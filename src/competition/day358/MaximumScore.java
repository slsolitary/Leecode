package competition.day358;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;

/**
 * @author heyao
 * @date 2023-08-14 9:31
 */
public class MaximumScore {
    public static void main(String[] args) {
        MaximumScore test = new MaximumScore();
    }

    private static final long MOD = (long)1e9+7;
    public int maximumScore(List<Integer> nums, int k) {
        var a = nums.stream().mapToInt(i -> i).toArray();
        int n = a.length;
        var left = new int[n];// 质数分数 >= getPrimes[nums[i]] 的左侧最近元素下标
        var right = new int[n];// 质数分数 > getPrimes[nums[i]] 的右侧最近元素下标
        Arrays.fill(right,n);
        var st = new ArrayDeque<Integer>();
        st.push(-1);
        for(int i = 0;i < n;i++){
            //当栈不为空，且峰值点对应的质数分数小于当前点对应的质数分数时
            while (st.size() > 1 && getPrimes(a[st.peek()]) < getPrimes(a[i])){
                //i即为st.peek()的右端点
                right[st.pop()] = i;
            }
            //此时st.peek()的质数分数≥i对应的质数分数，当前峰值点为i的左端点
            left[i] = st.peek();
            st.push(i);
        }
        var ids = new Integer[n];
        for(int i = 0;i < n;i++){
            ids[i]=i;
        }
        Arrays.sort(ids, (i, j) -> a[j] - a[i]);
        long ans = 1;
        for(int i : ids){
            long tot = (long)(i - left[i])*(right[i]-i);
            if(tot >= k){
                ans = ans * pow(a[i],k) % MOD;
                break;
            }
            ans = ans * pow(a[i],(int) tot) % MOD;
            k -= tot;
        }
        return (int) ans;
    }

    public static int getPrimes(int x){
        int cnt = 0;
        for(int i = 2;i <= x/i;i++){
            if(x % i == 0){
                while (x % i == 0){
                    x /= i;
                }
                cnt++;
            }
        }
        if(x > 1)
            cnt++;
        return cnt;
    }

    public long pow(long x, int n){
        long res = 1l;
        while (n > 0){
            if((n & 1) == 1){
                res = res * x % MOD;
            }
            x = x*x%MOD;
            n >>= 1;
        }
        return res;
    }
}
