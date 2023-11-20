package BingXing;

import com.sun.security.jgss.GSSUtil;
import competition.TreeAncestor;

/**
 * @author heyao
 * @date 2023-09-14 10:38
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        new Thread(()->{
            synchronized (A){
                System.out.println(Thread.currentThread()+"占有A");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"等待获取B");
                synchronized (B){
                    System.out.println(Thread.currentThread()+"占有B");
                }
            }
        }).start();
        new Thread(()->{
            synchronized (B){
                System.out.println(Thread.currentThread()+"占有B");
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"等待获取A");
                synchronized (A){
                    System.out.println(Thread.currentThread()+"占有A");
                }
            }
        }).start();
    }
}
