package com.stu.dealfile;

import java.io.File;

public class HbaseDao {
    //日志预处理：需要扫描的源文件
    private static String path = "D:/fileDemo/file1.txt";

    public static void main(String[] args) {
        //	Transform transform = new Transform();
        //	transform.CreateHbTable();	//在Hbase中创建表
        Operation operation = new Operation(path);
        //operation.insertTest(); //数据录入及预处理 ——日志数据导入到表中
        operation.MultiReadFiles();
        operation.openOutInputStream(new File("D:/fileDemo/file66666.txt"));
        //operation.createNotSpaceFile();
        operation.MultiUpload();
        //ConsumeDML(operation); //按照消费等级对用户分类
    }
}