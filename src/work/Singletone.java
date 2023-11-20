package work;

import java.util.ArrayList;
import java.util.List;

/**
 * @author heyao
 * @date 2023-09-01 15:26
 */
public class Singletone {
    private static Object A = new Object(),B = new Object();
    public static void main(String[] args) {
        new Thread(()->{
            System.out.println("线程1开始执行....");
            synchronized (A){
                try {
                    System.out.println("线程1拿到A锁");
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (B){
                    System.out.println("线程1拿到B锁");
                }
            }
        }).start();
        new Thread(()->{
            System.out.println("线程2开始执行....");
            synchronized (B){
                try {
                    System.out.println("线程2拿到B锁");
                    Thread.sleep(2000);
                }catch (Exception e){
                    e.printStackTrace();
                }
                synchronized (A){
                    System.out.println("线程2拿到A锁");
                }
            }
        }).start();
    }
}
