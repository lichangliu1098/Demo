package com.stu.synchronizedDo;

import java.util.List;

public class SyncThread implements Runnable{

    private static int count;

    private List<String> list = null;

    public SyncThread(){
        count=0;
    }

    public void countAdd(){
        synchronized (list){
            for (int i=0;i<5;i++){
                try{
                    System.out.println(Thread.currentThread().getName()+ ":" + (count++));
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    private void printCount(){
        for (int i = 0; i < 5; i ++) {
            try {
                System.out.println(Thread.currentThread().getName() + " count:" + count);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
         String threadName = Thread.currentThread().getName();
         if("A".equals(threadName)){
            countAdd();
        }else if("B".equals(threadName)){
            printCount();
         }
    }

    public int getCount(){
        return count;
    }
}
