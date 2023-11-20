package BingXing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author heyao
 * @date 2023-09-13 21:07
 */
public class MyBlockingQueue<T> {
    //当阻塞队列为空时，所有的消费者线程被阻塞，等待队列非空
    //生产者往队列里填入数据，队列通知消费者队列非空，消费者进行消费
    //当阻塞队列填满时，生产者被阻塞，等待队列非满
    //消费者消费数据，队列通知生产者队列未满，消费者进行消费
    private Queue<T> queue;
    private Lock lock;
    private int capacity;
    private Condition fullCondition;//条件队列
    private Condition emptyCondition;
    public MyBlockingQueue(int capacity){
        queue = new LinkedList<>();
        this.capacity = capacity;
        lock = new ReentrantLock();
        fullCondition = lock.newCondition();
        emptyCondition = lock.newCondition();
    }

    public void enqueue(T object) throws InterruptedException{
        try {
            lock.lock();
            while (queue.size() == capacity){//自旋
                System.out.println("生产者阻塞中...");
                fullCondition.await();
            }
            queue.add(object);
            emptyCondition.signal();
        }finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException{
        try {
            lock.lock();
            while (queue.isEmpty()){
                System.out.println("消费者阻塞中....");
                emptyCondition.await();
            }
            T poll = queue.poll();
//            fullCondition.signal();
            return poll;
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) throws InterruptedException {
//        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
//        //生产者
//        Thread producer = new Thread(()->{
//            try{
//                for(int i = 1;i <= 10;i++){
//                    queue.put(i);
//                    System.out.println("生产者添加元素："+i);
//                }
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//
//        CountDownLatch countDownLatch = new CountDownLatch(1);
//        //消费者
//        Thread consumer = new Thread(()->{
//            try {
//                int count = 0;
//                while (true){
//                    int element = queue.take();
//                    System.out.println("消费者消费元素："+element);
//                    count++;
//                    if(count == 10){
//                        break;
//                    }
//                }
//                countDownLatch.countDown();
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//        });
//        producer.start();
//        consumer.start();
//        producer.join();
//        consumer.join();
//        countDownLatch.await();
//        producer.interrupt();
//        producer.interrupt();
        MyBlockingQueue<Integer> queue = new MyBlockingQueue<>(5);
        //生产者
        Thread producer = new Thread(()->{
            try{
                for(int i = 1;i <= 10;i++){
                    queue.enqueue(i);
                    System.out.println("生产者添加元素："+i);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        CountDownLatch countDownLatch = new CountDownLatch(1);
        //消费者
        Thread consumer = new Thread(()->{
            try {
                int count = 0;
                while (true){
                    Thread.sleep(1000);
                    int element = queue.dequeue();
                    System.out.println("消费者消费元素："+element);
                    count++;
                    if(count == 10){
                        break;
                    }
                }
                countDownLatch.countDown();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        countDownLatch.await();
        producer.interrupt();
        producer.interrupt();
    }
}
