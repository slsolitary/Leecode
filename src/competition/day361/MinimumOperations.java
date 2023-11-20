package competition.day361;

/**
 * @author heyao
 * @date 2023-09-03 10:39
 */
public class MinimumOperations {
    public static void main(String[] args) {
        String s = "75";
        System.out.println(minimumOperations(s));
    }

    public static int minimumOperations(String num) {
        int n = num.length();
//        if(n == 1){
//             && num.equals('0')
//        }
        boolean[][] ex = new boolean[4][2];//判断"00" "25" "50" "75"是否出现，由于是倒序遍历，因此判断"00" "52" "05" "57"是否出现
        int index = 0;
        boolean isEnd = false;
        for(int i = n-1;i >= 0;i--){
            char c = num.charAt(i);
            //"00" "05"
            if(c == '0'){
                if(ex[0][0]){
                    ex[0][1] = true;
                    isEnd = true;
                }else {
                    ex[0][0] = true;
                }
                ex[2][0] = true;
            }
            //"52"
            if(c == '2' && ex[1][0]){
                ex[1][1] = true;
                isEnd = true;
            }
            //"57"
            if(c == '7' && ex[3][0]){
                ex[3][1] = true;
                isEnd = true;
            }
            //"52" "05" "57"
            if(c == '5'){
                ex[1][0] = true;
                if(ex[2][0]){
                    ex[2][1] = true;
                    isEnd = true;
                }
                ex[3][0] = true;
            }
            index++;
            if(isEnd){
                break;
            }
        }
        if(!isEnd){
            return ex[0][0] || ex[2][0] ? index-1 : index;
        }
        return index - 2;
    }
}
