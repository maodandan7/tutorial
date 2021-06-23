package com.naive.tutorial.thread;



/**
 * User zhongmeng-lizhaohong
 * Date 2021/3/3
 * Description:生产者消费者
 */
public class ProducerConsumerTest {

    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        Producer producer = new Producer(clerk);
        producer.setName("生产者");
        Consumer consumer = new Consumer(clerk);
        consumer.setName("消费者");
        producer.start();
        consumer.start();
    }
}

class Clerk extends Thread {
    private Integer count = 0;

    synchronized void produce() {
        if (count < 20) {
            count++;
            System.out.println(Thread.currentThread().getName() + "生产产品:" + count);
            notify();
        } else {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void consume() {
        if (count > 0) {
            System.out.println(Thread.currentThread().getName() + "消费产品" + count);
            count--;
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("开始生产产品");
        while (true) {
            clerk.produce();
        }
    }

}

class Consumer extends Thread {
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    public void run() {
        System.out.println("开始消费产品");
        while (true) {
            clerk.consume();
        }
    }
}
