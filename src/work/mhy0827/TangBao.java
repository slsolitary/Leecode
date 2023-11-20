package work.mhy0827;

import java.util.Scanner;

/**
 * @author heyao
 * @date 2023-08-27 20:34
 */
public class TangBao {
    static int step = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();//地图大小
        long h = input.nextLong();//米小游的战斗力
        //怪物位于(x,y)，初始战斗力为h，米小游每移动a次，怪物战力提升b
        int[][] boss = new int[2][5];
        for(int i = 0;i < 2;i++){
            for(int j = 0;j < 5;j++) {
                boss[i][j] = input.nextInt();
            }
        }
        int r = 1,c = 1;
        long tmp = h;
        for(int i = 0;i < 2;i++){
            long en = updateEn(r, c, boss[i][0], boss[i][1], boss[i][3], boss[i][4]);
            r = boss[i][0];
            c = boss[i][1];
            tmp = tmp-en-boss[i][2];
            step ++;
        }
        r = 1;c = 1;step = 0;
        for(int i = 1;i >= 0;i--){
            long en = updateEn(r, c, boss[i][0], boss[i][1], boss[i][3], boss[i][4]);
            r = boss[i][0];
            c = boss[i][1];
            h = h-en-boss[i][2];
            step++;
        }
        long ans = Math.max(h,tmp);
        if(ans < 0 )
            System.out.println("yingyingying");
        else
            System.out.println(ans);
    }

    //米小游从(r,c)走到(x,y)，怪物的战力提升ans
    public static long updateEn(int r,int c,int x,int y,int a,int b){
        step += Math.abs(x-r)+Math.abs(y-c);
        return (long) step / a * b;
    }
}
