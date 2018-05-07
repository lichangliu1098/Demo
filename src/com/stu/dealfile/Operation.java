package com.stu.dealfile;

import javax.security.auth.login.Configuration;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Operation {
    private Configuration conf;
    private static LinkedBlockingDeque<File> files;//即将上传的文件队列
    public static LinkedBlockingDeque<String> writerContents = new LinkedBlockingDeque<String>(150);
    private static ExecutorService UploadThreadPool = Executors.newFixedThreadPool(4);//上传文件线程池
    private static ExecutorService OutFileThreadPool = Executors.newFixedThreadPool(3);
    private String Table_1, Table_2;

    private static File createFile;
    private FileWriter out;

    /**
     * @param path 需要上传的文件夹路径
     */
    public Operation(String path) {
        files = new LinkedBlockingDeque<>();
        //读取文件列表
        ReadFiles(path);
    }

    /**
     * 读取文件列表到队列
     *
     * @param path
     */
    private void ReadFiles(String path) {
        System.out.println(path);
        File file = new File(path);
        if(file.isFile()){
            files.add(file);
        }else{
            File[] filen = file.listFiles();
            for (int i = 0; i < filen.length; i++) {
                files.add(filen[i]);
            }
        }
    }

    /**
     * 将文件内容读取到队列中
     */
    public void MultiReadFiles() {
        while (files.size() > 0) {
            try {
                new Util(files.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void createNotSpaceFile(){
        UploadThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                StringBuffer fileContents = new StringBuffer("");
                while (Util.Contents.size() == 0) {
                    try {
                        System.out.println("等待一秒=====");
                        Thread.sleep(1000 * 1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                while (Util.Contents.size() > 0) {
                    String contents = null;
                    try {
                        contents = Util.Contents.take();
                        fileContents.append(contents);
                    } catch (Exception e) {
                        try {
                            e.printStackTrace();
                            //插入失败，内容重回队列，准备再次插入
                            Util.Contents.put(contents);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }
                }
                //写入
                try {
                    out.write(fileContents.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                System.out.println("now numbers:========" + Util.Contents.size());
                try {
                    System.out.println("111");
                    Thread.sleep(1000 * 2);//线程终止2秒======
                    if (Util.Contents.size() == 0 && files.size() == 0) {
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        out.flush();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

    public void openOutInputStream(File file){
        try {
            /* 写入Txt文件 */
            createFile = file;
            createFile.createNewFile(); // 创建新文件
            out = new FileWriter(createFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void MultiUpload() {
        UploadThreadPool.execute(new Runnable() {
            @Override
            public void run() {
                    while (Util.Contents.size() == 0) {
                        try {
                            System.out.println("等待一秒");
                            Thread.sleep(1000 * 1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    int i=1;
                    while (Util.Contents.size() > 0) {
                        System.out.println("now numbers:" + Util.Contents.size());
                        String content = null;
                        try {
                            content = Util.Contents.take();
                            writerContents.put(content);
                            //out.write(content);//输出
                            //writerContents.put(content.toString());
                            //处理过程开始
                            System.out.println("内容处理次数 ===============:"+i+"threadName="+Thread.currentThread().getName());
                            //结束处理过程
                        } catch (Exception e) {
                            try {
                                e.printStackTrace();
                                //插入失败，内容重回队列，准备再次插入
                                Util.Contents.put(content);
                            } catch (InterruptedException e1) {
                                e1.printStackTrace();
                            }
                        }
                        while (Util.Contents.size() == 0 && files.size() > 0) {
                            try {
                                System.out.println("等待一秒");
                                Thread.sleep(1000 * 1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        i++;
                    }

                    try {
                        Thread.sleep(1000 * 2);//线程终止2秒
                        if (Util.Contents.size() == 0 && files.size() == 0) {
                            //outFileload();
                            System.exit(0);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            out.flush();
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        });

    }


    /*rivate void outFileload(){
        for(int i=0;i<3;i++){
            openOutInputStream(new File("D:/fileDemo/copyFile"+i+".txt"));
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (out){
                        try {
                            String context = writerContents.take().toString();
                            out.write(context);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }finally {
                            *//*try {
                                out.flush();
                                out.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }*//*
                        }
                    }
                }
            }).start();
        }
    }*/
}