package competition.day372;

import java.util.Arrays;

/**
 * @author heyao
 * @date 2023-11-19 10:58
 */
public class MaximumXorProduct {
    public static void main(String[] args) {
        long a = 0;
        long b = 3;
        int n = 1;
//        a = 53449611838892l;
//        b = 712958946092406l;
//        n = 6;
        MaximumXorProduct test = new MaximumXorProduct();
        System.out.println(test.maximumXorProduct(a, b, n));
    }

    public int maximumXorProduct(long a, long b, int n) {
        //保证a为最大的数
        if(a < b){
            long tmp = a;
            a = b;
            b = tmp;
        }
        //第一步：将a和b中均为0的位次改为1
        int MOD = (int) 1e9+7;
        long res = 0;
        String as = Long.toBinaryString(a);
        String bs = Long.toBinaryString(b);
        int len = 51;
        char[] arr = new char[len];
        Arrays.fill(arr,'0');
        char[] brr = new char[len];
        Arrays.fill(brr,'0');
        for(int i = 0;i < as.length();i++){
            arr[len-as.length()+i] = as.charAt(i);
        }
        for(int i = 0;i < bs.length();i++){
            brr[len-bs.length()+i] = bs.charAt(i);
        }
        for(int i = len-n;i < len;i++){
            if(arr[i] == '0' && brr[i] == '0'){
                arr[i] = '1';
                brr[i] = '1';
            }
        }
        //第二步：分配a和b中 为0和1的比特位
        //将高位1分配为a，剩余低位1分配给b
        //如果n小于a的位次，且a的前a.len-n位次有比b大的时，后n比特位中的1直接可以分配给b
        boolean flag = false;
        for(int i = 0;i < len-n;i++){
            if(arr[i] == '1' && brr[i] == '0'){
                flag = true;
                break;
            }
        }
        for(int i = len-n;i < len;i++){
            if(arr[i] == '1' && brr[i] == '0'){
                if(!flag)
                    flag = true;
                else {
                    arr[i] = '0';
                    brr[i] = '1';
                }
            }
        }
        //一定要注意：在这种取余的情况下，已经无法比较大小，取余后的值小不代表取余前的值小
        String aa = String.valueOf(arr);
        String bb = String.valueOf(brr);
        long anew = Long.parseLong(aa, 2);
        long bnew = Long.parseLong(bb, 2);
        res = (anew % MOD) * (bnew % MOD) % MOD;
        return (int) res;
    }
}
