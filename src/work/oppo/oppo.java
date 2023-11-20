package work.oppo;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-09-02 10:49
 */
public class oppo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//字符串长度
        int k = input.nextInt();//至少有k个子串
        String s = input.next();//字符串
//        //dp[i][0] 不进行修改的话，到i所拥有的oppo子串个数
//        //dp[i][1] 进行修改的话，到i所拥有的oppo子串个数
//        int[][] dp = new int[n][2];
        //[0,i]包括的oppo个数
        int[] oppoCount = new int[n];
        int count = 0;
        for(int i = n-4;i >= 0;i--){
            if(s.substring(i,i+4).equals("oppo")){
                count++;
                oppoCount[i] = count;
            }
        }
        if(count >= k){
            System.out.println(0);
        }
        //修改[0,i]包括的oppo个数
        int mk = 0;
        int[] dp = new int[n];
        for(int i = 3;i < n;i++){
            String tmp = s.substring(i-3,i+1);
            String op = "oppo";
            if(i  == 3)
                dp[i] = 1;
            else
                dp[i] = dp[i-2]+1;
            if(tmp.equals(op)){
                continue;
            }
            for(int j = 0;j < 4;j++){
                if(tmp.charAt(j) != op.charAt(j)){
                    mk++;
                }
            }
            s = s.substring(0,i-4)+op+s.substring(i,n);
            if(dp[i]+oppoCount[i+4] >= k){
                System.out.println(mk);
            }
            i += 3;
        }
    }
}
