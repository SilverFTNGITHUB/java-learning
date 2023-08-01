package com.pineftn.communication.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        //constructor
        // Client端：创建Socket，用于与指定IP和port号的Server端口建立通信 new Socket(ip address, port);
        Socket socket = new Socket("127.0.0.1", 8888);

        // 得到通道对应的OutputStream
        OutputStream oStream = socket.getOutputStream();

        //把低级的字节输出流包装成数据输出流
        DataOutputStream oDataStream = new DataOutputStream(oStream);

        // 写数据出去
        oDataStream.writeUTF("hello TCP");
        System.out.println("Client message sent!");

        oDataStream.close();
        socket.close();

    }
}
