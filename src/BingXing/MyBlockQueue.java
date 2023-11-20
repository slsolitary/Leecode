package BingXing;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author heyao
 * @date 2023-09-14 9:14
 */
public class MyBlockQueue<T> {
    private int capacity;
    private Lock lock;
    private Queue<T> queue;
    private Condition isFull;
    private Condition isEmpty;
    public MyBlockQueue(int capacity){
        this.capacity = capacity;
        queue = new LinkedList<T>();
        lock = new ReentrantLock();
        isEmpty = lock.newCondition();
        isFull = lock.newCondition();
    }

    public void enqueue(T object) throws InterruptedException{
        try {
            lock.lock();
            while (queue.size() == capacity){
                isFull.await();
            }
            queue.add(object);
            isEmpty.signal();
        }finally {
            lock.unlock();
        }
    }

    public T dequeue() throws InterruptedException{
        try {
            lock.lock();
            while (queue.isEmpty()){
                isEmpty.await();
            }
            T poll = queue.poll();
            return poll;
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyBlockQueue<Integer> blockQueue = new MyBlockQueue<>(5);
        int N = 10;
        Thread producer = new Thread(()->{
            try {
                for(int i = 0;i < N;i++){
                    blockQueue.enqueue(i);
                    System.out.println("生产者生产："+i);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        Thread consumer = new Thread(()->{
            try {
                int count = 0;
                while (true){
                    Integer i = blockQueue.dequeue();
                    System.out.println("消费者消费："+i);
                    count++;
                    if(count == 10){
                        break;
                    }
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        producer.interrupt();
        consumer.interrupt();
    }
}
