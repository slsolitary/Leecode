package BingXing;

/**
 * @author heyao
 * @date 2023-09-14 15:46
 */
public class Singleton {
    //执行顺序可能变成1 3 2
    //这样的话如果线程1执行了1和3，此时线程2进行调用的时候会直接返回singleton（未被初始化）
    private volatile static Singleton singleton;

    private Singleton(){}

    public static Singleton getSingleton(){
        if(singleton == null){
            synchronized (singleton){
                if(singleton == null){
                    singleton = new Singleton();
                    //1.为singleton分配空间
                    //2.初始化singleton
                    //3.将singleton指向分配的内存地址
                }
            }
        }
        return singleton;
    }
}
