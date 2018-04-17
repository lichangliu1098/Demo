package com.stu.synchronizedDo;

public class MySynchronized extends Thread
  {
   private int val;

   public MySynchronized(int v) {
     val = v;
   }

   public void printVal() {
    synchronized (this) {
     try{
      int j = 0;
       while (j<5) {
        val++;
        j++;
        System.out.println(Thread.currentThread().getName()+"===v===="+val);
        Thread.sleep(100);
       }
     }catch (InterruptedException e){
      e.printStackTrace();
     }

    }
   }

   public void run() {
    printVal();
   }
}

class Test{
 public static void main(String[] args){
    MySynchronized b = new MySynchronized(0);
    Thread a = new Thread(new MySynchronized(0),"111");
    Thread aa = new Thread(new MySynchronized(1),"222");
    a.start();
    aa.start();
 }
}
