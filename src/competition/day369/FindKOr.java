package competition.day369;

/**
 * @author heyao
 * @date 2023-10-29 10:30
 */
public class FindKOr {
    public static void main(String[] args) {
        int[] nums = {7,12,9,8,9,15};
        int k = 4;
        System.out.println(findKOr(nums, k));
    }
    public static int findKOr(int[] nums, int k) {
        int res = 0;
        int[] bits = new int[32];
        for(int i = 0;i < nums.length;i++){
            int tmp = nums[i];
            int j = 0;
            while ((tmp >> j) != 0){
                int a = (tmp >> j)&1;
                bits[j++] += a;
            }
        }
        for(int i = 0;i < 32;i++){
            if(bits[i] >= k){
                res += 1<<i;
            }
        }
        return res;
    }
}
