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
    public void run() {
        InputStream is = null;
        try {
            is = socket.getInputStream();

            //把低级的字节输入流包装成数据输入流
            DataInputStream dis = new DataInputStream(is);

            while (true) {
                try {
                    //阻塞等待，使用数据输入流读取客户端发送过来的信息
                    String rs = dis.readUTF();
                    System.out.println(rs);
                } catch (Exception e){
                    System.out.println("client disconnect: " + socket.getRemoteSocketAddress());
                    dis.close();
                    socket.close();
                    break;
                }

                System.out.println(socket.getRemoteSocketAddress());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
