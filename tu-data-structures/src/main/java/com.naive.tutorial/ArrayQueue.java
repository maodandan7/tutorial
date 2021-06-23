package com.naive.tutorial;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/5/21
 * Description:
 */
public class ArrayQueue {
    private Integer[] arr;
    private Integer maxSize;
    private Integer front;
    private Integer rear;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new Integer[maxSize];
        front = -1;
        rear = -1;
    }

    public Boolean isFull() {
        return rear == maxSize -1;
    }

    public Boolean isEmpty() {
        return rear == front;
    }

    public void add(Integer element) {
        if(isFull()) {
            throw new RuntimeException("队列已满！");
        }
        rear++;
        arr[rear] = element;
    }

    public Integer poll() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        front ++;
        return arr[front];
    }

    public Integer peek() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front + 1];
    }

    public void show() {
        if(isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        int count = front;
        while (true) {
            count ++;
            System.out.println(arr[count]);
            if(count == rear) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue = new ArrayQueue(3);
        System.out.println(arrayQueue.isEmpty());
        System.out.println(arrayQueue.isFull());
        arrayQueue.show();
        arrayQueue.add(1);
        System.out.println("队列头元素："  + arrayQueue.peek());
        System.out.println("出队列：" + arrayQueue.poll());
        System.out.println(arrayQueue.isEmpty());
        arrayQueue.add(2);
        arrayQueue.add(3);
        System.out.println(arrayQueue.isFull());
        arrayQueue.show();
    }
}
