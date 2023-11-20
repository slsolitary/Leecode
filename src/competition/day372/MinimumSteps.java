package competition.day372;

/**
 * @author heyao
 * @date 2023-11-19 10:42
 */
public class MinimumSteps {
    public long minimumSteps(String s) {
        long res = 0;
        int length = s.length();
        int l = 0,r = length-1;
        char[] array = s.toCharArray();
        while (l < r){
            while (l < length && s.charAt(l) == '0'){
                l++;
            }
            while (r >= 0 && s.charAt(r) == '1'){
                r--;
            }
            if(l >= length || r < 0 || l >= r){
                break;
            }
            res += r-l;
            array[l++] = '0';
            array[r--] = '1';
        }
        return res;
    }
}
