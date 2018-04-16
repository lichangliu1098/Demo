package com.stu.threaddo;

public class Station extends Thread{

    public Station(String name){
        super.setName(name);
    }

    volatile static int tick = 20;

    private static byte[] lock = new byte[0];

    @Override
    public void run() {
        while(tick > 0){
            synchronized (lock){
                if(tick >0){
                    System.out.println(getName()+"卖出了第["+tick+"]票");
                    tick--;
                }else{
                    System.out.println("票卖完了");
                }
            }
            try {
                sleep(1000);//休息一秒
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MainClass {
    /**
     * java多线程同步锁的使用
     * 示例：三个售票窗口同时出售10张票
     * */
    public static void main(String[] args) {
//实例化站台对象，并为每一个站台取名字
        Station station1=new Station("窗口1");
        Station station2=new Station("窗口2");
        Station station3=new Station("窗口3");

// 让每一个站台对象各自开始工作
        station1.start();
        station2.start();
        station3.start();

    }

}
