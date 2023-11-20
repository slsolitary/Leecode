package competition.day356;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author heyao
 * @date 2023-07-30 11:14
 */
public class minimumStringL {
    public static void main(String[] args) {
    }
    public String minimumString(String a, String b, String c) {

        String[]  s = {a,b,c};
        String res = "";
        for(int i = 0;i < 3;i++){
            for(int j = 0;j < 3;j++){
                for(int k = 0;k < 3;k++){
                    if(i != j && j != k && i != k){
                        String tmp = concatString(s[i], s[j], s[k]);
                        if(res.length() != 0){
                            res = compareString(res,tmp);
                        }else {
                            res = tmp;
                        }
                    }
                }
            }
        }
        return res;
    }

    public String concatString(String a,String b,String c){
        StringBuilder sb = new StringBuilder(a);
        int n = a.length(),m = b.length(),l = c.length();
        if(!a.contains(b)){
            for(int i = m-1;i >= -1;i--){
                if(i == -1){
                    sb.append(b);
                    break;
                }
                int idx = a.lastIndexOf(b.substring(0,i+1));
                if(idx > -1 && idx+i+1 == a.length()){
                    sb.append(b,i+1,m);
                    break;
                }
            }
        }
        String tmp = sb.toString();
        if(!tmp.contains(c)){
            for(int i = l-1;i >= -1;i--){
                if(i == -1){
                    sb.append(c);
                    break;
                }
                int idx = tmp.lastIndexOf(c.substring(0,i+1));
                if(idx > -1 && idx+i+1 == tmp.length()){
                    sb.append(c,i+1,l);
                    break;
                }
            }
        }
        return sb.toString();
    }

    public String compareString(String a,String b){
        int m = a.length(),n = b.length();
        if(m == n){
            return a.compareTo(b) <= 0 ? a:b;
        }
        return m < n ? a:b;
    }
}
