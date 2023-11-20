package competition.day361;

import java.util.ArrayList;

/**
 * @author heyao
 * @date 2023-09-03 10:32
 */
public class CountSymmetricIntegers {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low;i <= high;i++){
            int num = i;
            ArrayList<Integer> list = new ArrayList<>();
            while (num != 0){
                list.add(num % 10);
                num /= 10;
            }
            if(list.size() % 2 == 1){
                continue;
            }
            int pre = 0,after = 0;
            for(int j = 0;j < list.size()/2;j++){
                pre += list.get(j);
                after += list.get(list.size()-1-j);
            }
            if(pre == after){
                count++;
            }
        }
        return count;
    }
}
