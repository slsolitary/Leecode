package competition.day356;

/**
 * @author heyao
 * @date 2023-07-31 14:47
 */
public class countStepping {
    public static void main(String[] args) {
        countStepping test = new countStepping();
        System.out.println(test.countSteppingNumbers("90", "101"));
    }
    private static final int MOD = (int) 1e9+7;
    public int countSteppingNumbers(String low, String high) {
        int len = high.length();
        int[][] memo = new int[len+1][10];//长度为i，j为最高位的步进数字的数目
        for(int i = 0;i <= 9;i++){
            memo[1][i]=1;
        }
        for(int i = 2;i <= len;i++){
            for(int j = 0;j <= 9;j++){
                for(int k = 0;k <= 9;k++){
                    if(Math.abs(j-k) == 1){
                        memo[i][j] = (memo[i][j]+memo[i-1][k]) % MOD;
                    }
                }
            }
        }

        return (int) ((query(high,memo)-query(low,memo)+ (valid(high) ? 1:0)) % MOD);
    }

    long query(String s,int[][] memo){
        int len = s.length();

        //取出s的每一位
        int[] num = new int[len];
        for(int i = 0;i < len;i++){
            num[i] = s.charAt(i)-'0';
        }

        long res = 0l;
        //长度小于s的步进数字个数
        for(int i = 1;i < len;i++){
            for(int j = 1;j <= 9;j++){
                res += memo[i][j];
            }
        }
        //长度等于s，但最高位小于s最高位的步进数字个数
        for(int j = 1;j < num[0];j++){
            res += memo[len][j];
        }
        //长度等于s，最高位等于s的最高位，但后面数位小于s的这一数位的步进数字的数目
        //例如123456，固定最高位，统计长度为5，最高位为2的步进数字数目；固定前两位，统计长度为4，最高位为3的步进数字数目...
        for(int i = 1;i < len;i++){//i 对应数位，从高到低
            for(int j = 0; j < num[i];j++){
                if(Math.abs(j-num[i-1]) == 1){
                    res += memo[len-i][j];
                }
            }
            if(Math.abs(num[i]-num[i-1]) != 1){
                break;
            }
        }
        return res;
    }

    private boolean valid(String s){
        for(int i = 1;i < s.length();i++){
            if(Math.abs((int)(s.charAt(i-1)-s.charAt(i))) != 1)
                return false;
        }
        return true;
    }
}
