package com.stu.linkedblockdeque;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class createFile {

    public static void main(String[] args){
            try {
                /* 写入Txt文件 */
                File writename = new File("D:/fileDemo/file1.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
                if(writename.isFile()){
                    writename.delete();
                }
                writename.createNewFile(); // 创建新文件
                FileWriter  out = new FileWriter(writename);
                String fileContents = null;
                for(int i=1;i<=7000001;i++) {
                    fileContents = "{\"count\":\""+i+"\",\"action\":\"GetItem\",\"time\":\"1409932200\",\"avatar_id\":\"100188\",\"userid\":\"0\",\"item_id\":\"20004\",\"level\":\"60\",\"requeat_method\":\"unknown\"}\r\n";
                    out.write(fileContents.toString());// \r\n即为换行
                }
                out.flush(); // 把缓存区内容压入文件
                out.close(); // 最后记得关闭文件

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
}
