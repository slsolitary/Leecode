package competition.day366;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author heyao
 * @date 2023-10-08 10:40
 */
public class MinOperations {
    public int minOperations(String s1, String s2, int x) {
        if(s1.equals(s2)){
            return 0;
        }
        ArrayList<Integer> p = new ArrayList<>();
        for(int i = 0;i < s1.length();i++){
            if(s1.charAt(i) != s2.charAt(i)){
                p.add(i);
            }
        }
        if(p.size() % 2 != 0){
            return -1;
        }
        return -1;
//        char[] s = s1.toCharArray();
//        char[] t = s2.toCharArray();
//        int n = s.length,diff = 0;
//        //反转字符并不会改变s1中1的个数的奇偶性
//        //只要s1和s2的1的个数一个为奇数一个为偶数，返回-1
//        for(int i = 0;i < n;i++){
//            if(s[i] == '1'){
//                diff++;
//            }
//            if(t[i] == '1'){
//                diff--;
//            }
//        }
//        if(Math.abs(diff) % 2 == 1){
//            return -1;
//        }
//        //当前下标i，免费反转次数j，上一个字符是否选择了第二种操作preRev
//        int[][][] memo = new int[n][n+1][2];
//        for(int i = 0;i < n;i++){
//            for(int j = 0;j <= n;j++){
//                Arrays.fill(memo[i][j],-1);//-1表示没有计算过
//            }
//        }
//        return -1;
    }

    private int dfs(int i,int j,int preRev,int[][][] memo,char[] s,char[] t,int x){
        if(i < 0){
            return j > 0 || preRev > 0 ? Integer.MAX_VALUE / 2 : 0;
        }
        if(memo[i][j][preRev] != -1){
            return memo[i][j][preRev];
        }
        if((s[i] == t[i]) == (preRev == 0)){
            return dfs(i-1,j,0,memo,s,t,x);
        }
        int res = Math.min(dfs(i - 1, j + 1, 0, memo, s, t, x) + x, dfs(i - 1, j, 1, memo, s, t, x) + 1);
        if(j > 0){
            res = Math.min(res, dfs(i - 1, j - 1, 0, memo, s, t, x));
        }
        return memo[i][j][preRev] = res;
    }
}
