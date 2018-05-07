package com.stu.dealfile;

import java.io.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Util {
    public static LinkedBlockingDeque<String> Contents = new LinkedBlockingDeque<String>(1500);//内容阻塞队列
    private static ExecutorService ReadThreadPool = Executors.newFixedThreadPool(5);
    //读文件线程池
    private File file;
    BufferedReader reader = null;
    FileInputStream fileInputStream = null;

    public Util(File file) {
        this.file = file;
        MultiReadFile();
    }

    private void MultiReadFile() {
        if (file.isFile()) {
            if (file.getName().endsWith(".txt")) {
                try {
                    fileInputStream = new FileInputStream(file);
                    InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
                    reader = new BufferedReader(inputStreamReader);
                    Util.ReadThreadPool.execute(new MultiReadFile());//开始多线程读取文件
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                    System.out.println(file.getName() + "文件不存在");
                } catch (UnsupportedEncodingException e) {
                    System.out.println(file.getName() + "文件内容格式不支持，请使用UTF-8");
                }
            }
        }
    }

    class MultiReadFile implements Runnable {
        @Override
        public void run() {
            //对于需要反复增加的String,使用StringBuild能够提高效率
            StringBuilder lines = new StringBuilder();
            String line1 = "";
            int num = 0;//行数
            synchronized (reader) {
                try {
                    while ((line1 = reader.readLine()) != null) {
                        num++;
                        lines.append(line1);
                        if (num > 7000) {//大于1000行时就存入队列
                            try {
                                Util.Contents.put(lines.toString());
                                lines.delete(0, lines.length());//清空StringBuilder,不要更改为其它清空方法，此方法效率高
                                num = 0;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    if (num != 0) {
                        try {
                            Util.Contents.put(lines.toString());
                            lines.delete(0, lines.length());//清空StringBuilder,不要更改为其它清空方法，此方法效率高
                            num = 0;
                            line1 = "";
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            System.out.println("数据没放入队列");
                        }
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("读取文件中出了点错误");
                } finally {
                    try {
                        System.out.println("文件" + file.getName() + "读取完毕");
                        reader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}