package com.stu.threadpoolexecutor;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableImpl implements Callable<String> {

    private  String acceptStr;

    public CallableImpl(String acceptStr){
        this.acceptStr = acceptStr;
    }

    @Override
    public String call() throws Exception{

        Thread.sleep(1000);
        return this.acceptStr + "append some chars and return it!";
    }

    public static void main(String[] args){
        Callable<String> callable = new CallableImpl("my callable test!");
        FutureTask<String> task = new FutureTask<>(callable);
        long beginTime = System.currentTimeMillis();
        new Thread(task).start();
        try {
            String result = null;
            result = task.get();
            long endTime = System.currentTimeMillis();
            System.out.println("helle :" +result);
            System.out.println("cast :" +(endTime - beginTime)/1000 + "second!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
