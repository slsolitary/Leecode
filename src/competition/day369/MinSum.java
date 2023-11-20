package competition.day369;

/**
 * @author heyao
 * @date 2023-10-29 10:40
 */
public class MinSum {
    public static void main(String[] args) {
        int[] nums1 = {0,16,28,12,10,15,25,24,6,0,0};
        int[] nums2 = {20,15,19,5,6,29,25,8,12};
        System.out.println(minSum(nums1, nums2));
    }
    public static long minSum(int[] nums1, int[] nums2) {
        long res = 0l;
        long sum1 = 0,sum2 = 0;
        int z1 = 0,z2 = 0;
        for(int i = 0;i < nums1.length;i++){
            if(nums1[i] == 0){
                z1++;
            }else {
                sum1 += nums1[i];
            }
        }
        for(int i = 0;i < nums2.length;i++){
            if(nums2[i] == 0){
                z2++;
            }else {
                sum2 += nums2[i];
            }
        }
        long a = sum1+z1;
        long b = sum2+z2;
        if(a > b && z2 != 0){
            return a;
        }else if(a < b && z1 != 0){
            return b;
        }else if(a == b){
            return a;
        }
        return -1;
    }
}
