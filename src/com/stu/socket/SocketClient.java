package com.stu.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("192.168.1.3",5209);
            System.out.println("客户端启动成功");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            PrintWriter writer = new PrintWriter(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String readline;
            readline = br.readLine();
            while(!readline.equals("end")){
                writer.println(readline);
                writer.flush();
                System.out.println("Client:" +readline);
                System.out.println("Server:" + in.readLine());
                readline = br.readLine();
            }
            writer.close();
            in.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("can hot listen to:"+e);
        }
    }
}
