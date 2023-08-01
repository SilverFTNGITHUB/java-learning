package com.pineftn.communication.tcp_multilcient;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("----Server is running-----");

        while(true) {
            //等待客户端
            Socket socket = serverSocket.accept();
            System.out.println("connected from " + socket.getRemoteSocketAddress());

            //把客户端对应的socket通信掼到交给独立线程处理
            new ServerReaderThread(socket).start();
        }
    }
}
