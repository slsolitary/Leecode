package hot100;

import java.util.HashMap;

/**
 * @author heyao
 * @date 2023-07-31 16:19
 * 76.最小覆盖子串
 */
public class minWindows {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if(m < n)
            return "";
        int[] count = new int[128];
        for(int i = 0;i < n;i++){
            count[t.charAt(i)]++;
        }
        int left = 0,right = 0;
        int minLen = Integer.MAX_VALUE,start = 0;
        while (right < m){
            char c = s.charAt(right);
            if(count[c] > 0){
                n--;
            }
            count[c]--;

            if(n == 0){
                while (count[s.charAt(left)] < 0){
                    count[s.charAt(left)]++;
                    left++;
                }

                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    start = left;
                }

                count[s.charAt(left)]++;
                left++;
                n++;
            }
            right++;
        }
        return minLen==Integer.MAX_VALUE?"":s.substring(start,start+minLen);
    }
}
