package competition.day357;

/**
 * @author heyao
 * @date 2023-08-06 10:30
 */
public class FindString {
    public static void main(String[] args) {
        FindString test = new FindString();
        String s = "poiinter";
        System.out.println(test.finalString(s).toString());
    }
    public String finalString(String s) {
        StringBuilder builder = new StringBuilder();
        int n = s.length();
        for(int i = 0;i < n;i++){
            char c = s.charAt(i);
            if(c == 'i'){
                builder.reverse();
            }else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
