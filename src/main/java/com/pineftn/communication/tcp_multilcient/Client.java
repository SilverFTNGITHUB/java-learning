package com.pineftn.communication.tcp_multilcient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        // 建立客户端端口
        Socket socket = new Socket("127.0.0.1", 8888);

        // 字节输出流
        OutputStream outputStream = socket.getOutputStream();
        //把低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(outputStream);
        // 写数据出去
        dos.writeUTF("Client传信");

        // 关闭输出流
        dos.close();
        // 关闭客户端端口
        socket.close();

    }
}
