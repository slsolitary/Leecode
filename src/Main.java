import java.util.Collections;
import java.util.List;

/**
 * @author heyao
 * @date 2023-10-26 10:46
 */
public class Main extends Thread{
    public static void main(String[] args) {
//        int c = test();
//        System.out.println(c);
//        System.out.println(",");
        Main t = new Main();
        Main s = new Main();
        t.start();
        System.out.println("how");
        s.start();
        System.out.println("are");
    }

    public void run(){
        System.out.println("you");
    }

    public static int test(){
        int a = 0;
        try {
            int b = 24/a;
            return a;
        }catch (Exception e){
            a += 1;
            return a;
        }finally {
            a += 1;
            System.out.println(a);
            System.out.println(",");
        }
    }

}
