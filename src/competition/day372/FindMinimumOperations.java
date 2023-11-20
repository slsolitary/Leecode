package competition.day372;

/**
 * @author heyao
 * @date 2023-11-19 10:30
 */
public class FindMinimumOperations {
    public static void main(String[] args) {
        String s1 = "cc";
        String s2 = "cccb";
        String s3 = "c";
        System.out.println(findMinimumOperations(s1, s2, s3));
    }
    public static int findMinimumOperations(String s1, String s2, String s3) {
        int index = -1;
        int res = 0;
        for(int i = 0;i < s1.length() && i < s2.length();i++){
            if(s1.charAt(i) == s2.charAt(i)){
                index = i;
            }else {
                break;
            }
        }
        int newIndex = -1;
        for(int i = 0;i <= index && i < s3.length();i++){
            if (s1.charAt(i) == s3.charAt(i)){
                newIndex = i;
            }else {
                break;
            }
        }
        if(newIndex == -1){
            return -1;
        }
        res = s1.length()+s2.length()+s3.length()-3*(newIndex+1);
        return res;
    }
}
