package com.pineftn.communication.tcp_multilcient;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    /**
     *
     */
    public void run() {
        //代码是有问题的 我不知道标准形式怎么写
        try {
            // 得到通道的字节输入流
            InputStream inputStream = socket.getInputStream();
            // 把低级的字节输入流包装成数据输入流
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            // 收取单个通道中的多条信息
            while (true) {

                //阻塞等待完整的一条信息，使用数据输入流读取客户端发送过来的信息
                String receiveStr = dataInputStream.readUTF();
                System.out.println(receiveStr);

                System.out.println("client disconnect: " + socket.getRemoteSocketAddress());
                dataInputStream.close();
                socket.close();
                break;

            }
        } catch (IOException e) {
            // 当通道被关闭了
            throw new RuntimeException(e);
        }
    }
}
