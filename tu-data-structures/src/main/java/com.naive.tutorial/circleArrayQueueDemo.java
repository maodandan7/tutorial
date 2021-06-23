package com.naive.tutorial;

/**
 * User zhongmeng-lizhaohong
 * Date 2020/10/20
 * Description:利用数组实现环形队列
 */
public class circleArrayQueueDemo {

    static class CircleArrayQueue {
        private Integer maxSize;
        private Integer[] array;
        private Integer front;
        private Integer rear;

        public CircleArrayQueue(Integer maxSize) {
            this.maxSize = maxSize;
            array = new Integer[maxSize];
            front = 0;
            rear = 0;
        }

        public Boolean isFull() {
            return  (rear + 1) % maxSize == front;
        }

        public Boolean isEmpty() {
            return rear == front;
        }

        public Integer getSize() {
            return (rear + maxSize - front) % maxSize;
        }

        public void add(Integer element) {
            if(isFull()) {
                throw new RuntimeException("队列已满");
            }
            rear = (rear + 1) % maxSize;
            array[rear] = element;
        }

        public Integer poll() {
            if(isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            front =  (front+1) % maxSize;
            return array[front];
        }

        public Integer peek() {
            return array[(front+1) % maxSize];
        }

        public void show() {
            if(isEmpty()) {
                throw new RuntimeException("队列为空");
            }
            int index = front;
            while (true) {
                index++;
                System.out.println(array[index % maxSize]);
                if(index % maxSize == rear) {
                    break;
                }
            }
        }

//        public boolean isFull() {
//            return (rear + 1) % maxSize == front;
//        }
//
//        public boolean isEmpty() {
//            return rear == front;
//        }
//
//        public Integer getSize() {
//            return (rear + maxSize - front) % maxSize;
//        }
//
//        public void add(int n) {
//            if (isFull()) {
//                System.out.println("队列已满");
//                return;
//            }
//            array[rear] = n;
//            rear = (rear + 1) % maxSize;
//        }
//
//        public Integer poll() {
//            if (isEmpty()) {
//                throw new RuntimeException("队列为空");
//            }
//            Integer result = array[front];
//            front = (front + 1) % maxSize;
//            return result;
//        }
//
//        public void show() {
//            if(isEmpty()) {
//                System.out.println("队列为空");
//                return;
//            }
//            for (int i = front; i < front + getSize(); i++) {
//                System.out.printf("array[%d]=%d\n", i % maxSize, array[i % maxSize]);
//            }
//        }
    }

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.isFull());
        queue.show();
        queue.poll();
        queue.poll();
        queue.show();
    }


}
