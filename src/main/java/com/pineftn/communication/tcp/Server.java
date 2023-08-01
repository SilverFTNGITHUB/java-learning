package com.pineftn.communication.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/*
ServerSocket-监听指定的ServerSocket（port xxx）。在有新的Client给该xxx port发信时，创建一个新的Socket对象（临时port号）以建立tcp连接
socket-端口
使用IOStream进行传信
 */
public class Server {
    public static void main(String args[]) throws IOException {
        // 监听器，监听指定的Server端口号，在有Client向该端口请求建立通道时，创建临时端口
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("ServerSocket started! port = " + serverSocket.getLocalPort());

        //serverSocket监听到Client端连接请求，创建新的socket进行连接
        Socket socket = serverSocket.accept();
        System.out.println("new Server Socket created, port = " + socket.getLocalPort() + ", remote ip = " + socket.getRemoteSocketAddress());

        //得到通道对应的输入流（通过这个输入流，Server端可以从Client端读取数据）
        InputStream iStream = socket.getInputStream();
        //把低级的字节输入流包装成数据输入流
        DataInputStream iDataStream = new DataInputStream(iStream);

        //阻塞等待，直到接收到完整的utf-8字符串
        String receiveStr = iDataStream.readUTF();
        System.out.println(receiveStr);

        iDataStream.close();
        socket.close();
        serverSocket.close();
    }
}
