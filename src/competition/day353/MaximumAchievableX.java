package competition.day353;

public class MaximumAchievableX {
    public int theMaximumAchievableX(int num, int t) {
        int tmp=num;
        int x = num+t*2;
        for(;x >= num;x--){
            if(x - t == tmp+t){
                return x;
            }
            tmp--;
        }
        return 0;
    }
}
