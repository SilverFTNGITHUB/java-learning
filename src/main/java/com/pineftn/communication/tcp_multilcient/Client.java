package com.pineftn.communication.tcp_multilcient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);

        OutputStream os = socket.getOutputStream();

        //把低级的字节输出流包装成数据输出流
        DataOutputStream dos = new DataOutputStream(os);

        // 写数据出去
        dos.writeUTF("Client传信");
        dos.close();

        socket.close();

    }
}
