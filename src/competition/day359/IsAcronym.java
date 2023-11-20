package competition.day359;

import java.util.List;

/**
 * @author heyao
 * @date 2023-08-20 10:30
 */
public class IsAcronym {
    public boolean isAcronym(List<String> words, String s) {
        int length = words.size();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < length;i++){
            char c = words.get(i).charAt(0);
            sb.append(c);
        }
        return sb.toString().equals(s);
    }
}
