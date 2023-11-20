package hot100;

/**
 * @author heyao
 * @date 2023-08-02 9:17
 */
public class ProductExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length,tmp = 1;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1;i < n;i++){
            res[i] = res[i-1]*nums[i-1];
        }
        for(int i = n-2;i >= 0;i--){
            tmp *= nums[i+1];
            res[i] *= tmp;
        }
        return res;
//        int[] pre = new int[n];
//        int[] suffer = new int[n];
//        pre[0] = 1;suffer[n-1] = 1;
//        for(int i = 1;i < n;i++){
//            pre[i] = pre[i-1]*nums[i-1];
//        }
//        for(int i = n-2;i >= 0;i--){
//            suffer[i] = suffer[i+1]*nums[i+1];
//        }
//        for(int i = 0;i < n;i++){
//            pre[i] = pre[i]*suffer[i];
//        }
//        return pre;
    }
}
