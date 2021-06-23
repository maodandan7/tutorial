package com.naive.tutorial.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * User zhongmeng-lizhaohong
 * Date 2021/3/3
 * Description:callable的使用
 */
public class CallableTest {
    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new Task());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        int  sum = 0;
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0)  {
                sum += i;
            }
        }
        return sum;
    }
}
