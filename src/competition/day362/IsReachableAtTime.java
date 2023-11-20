package competition.day362;

/**
 * @author heyao
 * @date 2023-09-10 10:42
 */
public class IsReachableAtTime {
    public static void main(String[] args) {
        System.out.println(isReachableAtTime(1, 1, 1, 1, 3));
    }
    public static boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if(sx == fx && sy == fy){
            return t != 1;
        }
        long x = Math.abs(sx-fx);
        long y = Math.abs(sy-fy);
        long maxTime = (x+1) * (y+1)-1;
        long minTime = Math.min(x,y);
        if(x < y){
            minTime += y-x;
        }else {
            minTime += x - y;
        }
        return t >= minTime;
    }
}
