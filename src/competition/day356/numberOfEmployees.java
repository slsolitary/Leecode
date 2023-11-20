package competition.day356;

/**
 * @author heyao
 * @date 2023-07-30 10:31
 */
public class numberOfEmployees {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int n = hours.length;
        int res = 0;
        for(int i = 0;i < n;i++){
            if(hours[i] >= target){
                res++;
            }
        }
        return res;
    }
}
